package com.itheima.core.service;

import com.google.common.collect.Lists;
import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.ProductQuery;
import com.itheima.core.service.solr.SolrService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    public Pagination selectPaginationByQuery(Integer pageNo,String keyword) throws Exception {
        //商品对象Query
        ProductQuery productQuery = new ProductQuery();
        //当前页
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        productQuery.setPageSize(8);
        SolrQuery solrQuery = new SolrQuery();

        StringBuilder params = new StringBuilder();

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
            product.setName(name);
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
}
