package com.itheima.core.service;

import com.google.common.collect.Lists;
import com.itheima.common.page.Pagination;
import com.itheima.common.redis.RedisUtil;
import com.itheima.core.dao.product.ProductDao;
import com.itheima.core.dao.product.SkuDao;
import com.itheima.core.pojo.product.*;
import com.itheima.core.service.solr.SolrService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Auther: wanglei
 * @Date: 2019.08.29
 * @Description: com.itheima.core.service
 * @version: 1.0
 */
@Service("solrService")
public class SolrServiceImpl implements SolrService {
    @Autowired
    private SolrServer solrServer;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private SkuDao skuDao;

    /**
     * 根据关键词查询solr指定域中的数据
     * @param pageNo
     * @param keyword
     * @return
     * @throws Exception
     */
    public Pagination selectPaginationByQuery(Integer pageNo,String keyword,Long brandId,String price) throws Exception {
        //商品对象Query
        ProductQuery productQuery = new ProductQuery();
        //当前页
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        productQuery.setPageSize(8);
        SolrQuery solrQuery = new SolrQuery();

        StringBuilder params = new StringBuilder();

        //设定查询内容
        solrQuery.setQuery(keyword);
        //默认查询的域 df default field
        solrQuery.set("df","name_ik");
        //条件
        if(StringUtils.isNotBlank(keyword)){
            //关键词
            params.append("keyword=").append(keyword);
        }
        //分页
        solrQuery.setStart(productQuery.getStartRow());
        solrQuery.setRows(productQuery.getPageSize());
        //排序
        solrQuery.setSort("price",SolrQuery.ORDER.asc);
        //查询指定的域  field list
        solrQuery.set("fl", "id,name_ik,price,url");
        //高亮
        //1.打开高亮的开关
        solrQuery.setHighlight(true);
        //2.设置高亮的字段
        solrQuery.addHighlightField("name_ik");
        //3.设置高亮的前缀
        solrQuery.setHighlightSimplePre("<span style='color:red'>");
        //4.设置高亮的后缀
        solrQuery.setHighlightSimplePost("</span>");
        //过滤条件
        if (brandId!=null){
            solrQuery.addFilterQuery("brandId:"+brandId);
            params.append("&brandId=").append(brandId);
        }
        //0-99 1600
        if (StringUtils.isNotBlank(price)){
            String[] p = price.split("-");
            if (p.length==2){
                solrQuery.addFilterQuery("price:["+p[0]+" TO "+p[1]+"]");
            }else{
                solrQuery.addFilterQuery("price:["+p[0]+" TO *]");
            }
            params.append("&price=").append(price);
        }
        //执行查询
        QueryResponse response = solrServer.query(solrQuery);
        //取出高亮数据
        Map<String, Map<String, List<String>>> highlighting = response.getHighlighting();
        //返回结果集
        SolrDocumentList docs = response.getResults();
        //返回总条数
        Long numFound = docs.getNumFound();
        //创建商品结果集
        List<Product> products = Lists.newArrayList();

        //遍历结果集
        for (SolrDocument doc : docs) {
            Product product = new Product();
            //商品ID
            String id = (String)doc.get("id");
            product.setId(Long.parseLong(id));
            //商品名称
            String name = (String)doc.get("name_ik");
            //取出高亮数据
            Map<String, List<String>> map = highlighting.get(id);
            List<String> list = map.get("name_ik");
            product.setName(list.get(0));
            //价格
            product.setPrice((Float)doc.get("price"));
            //图片URL
            String url = (String)doc.get("url");
            product.setImgUrl(url);

            products.add(product);
        }

        //构建分页
        Pagination pagination = new Pagination(productQuery.getPageNo(),productQuery.getPageSize(),numFound.intValue(),products);
        pagination.pageView("/Search",params.toString());
        return pagination;
    }

    /**
     * redis缓存中查询品牌结果集
     * @return
     */
    @Override
    public List<Brand> selectBrandList() {
        List<Brand> brandList = Lists.newArrayList();
        Map<Object, Object> brandMap = redisUtil.hmget("brand");
        if (brandMap!=null&&!brandMap.isEmpty()){
            Set<Map.Entry<Object, Object>> entrySet = brandMap.entrySet();
            for (Map.Entry<Object, Object> entry : entrySet) {
                Brand brand = new Brand();
                brand.setId(Long.parseLong(entry.getKey().toString()));
                brand.setName(entry.getValue().toString());
                brandList.add(brand);
            }
        }
        return  brandList;
    }

    /**
     * 保存商品信息到solr服务器
     * @param id
     */
    public void insertProductToSolr(Long id) throws Exception {
        //保存商品信息到solr服务器keyword==商品名称
        SolrInputDocument doc = new SolrInputDocument();
        //solr服务器保存商品信息
        Product p = productDao.selectByPrimaryKey(id);
        //1.商品ID
        doc.setField("id",id);

        doc.setField("name_ik",p.getName());
        doc.setField("brandId",p.getBrandId());
        doc.setField("url",p.getImgUrl());

        //查询商品关联库存:select price from bbs_sku where product_id = 442 order by price desc limit 1
        SkuQuery skuQuery = new SkuQuery();
        //查询字段price
        skuQuery.setFields("price");

        //product_Id=?
        skuQuery.createCriteria().andProductIdEqualTo(id);
        //order by
        skuQuery.setOrderByClause("price desc");
        //limit
        skuQuery.setPageNo(1);
        skuQuery.setPageSize(1);
        //获取库存表商品最低价格
        List<Sku> skus = skuDao.selectByExample(skuQuery);
        doc.setField("price",skus.get(0).getPrice());
        doc.setField("last_modified", new Date());

        solrServer.add(doc);
        solrServer.commit();

    }
}
