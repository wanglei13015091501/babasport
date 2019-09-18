package com.itheima.core.service.product;

import com.google.common.collect.Lists;
import com.itheima.common.page.Pagination;
import com.itheima.common.redis.RedisUtil;
import com.itheima.core.dao.product.ProductDao;
import com.itheima.core.dao.product.SkuDao;
import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.ProductQuery;
import com.itheima.core.pojo.product.ProductQuery.Criteria;
import com.itheima.core.pojo.product.Sku;
import com.itheima.core.pojo.product.SkuQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.08.02
 * @Description: com.itheima.core.service.product
 * @version: 1.0
 */
@Service("productService")
@Transactional(readOnly = true,propagation = Propagation.REQUIRED)
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private SkuDao skuDao;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Override
    public Pagination selectProList(Integer pageNo, String name, Long brandId, Boolean isShow) {
        ProductQuery productQuery = new ProductQuery();

        //当前页
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        productQuery.setPageSize(5);

        Criteria criteria = productQuery.createCriteria();

        StringBuilder params = new StringBuilder();
        //判断
        if(null != name){
            criteria.andNameLike("%" + name  + "%");
            params.append("name=").append(name);
        }
        if(null != brandId){
            criteria.andBrandIdEqualTo(brandId);
            params.append("&brandId=").append(brandId);
        }
        if(null != isShow){
            criteria.andIsShowEqualTo(isShow);
            params.append("&isShow=").append(isShow);
        }else{
            //默认下架
            criteria.andIsShowEqualTo(false);
            params.append("&isShow=").append(false);
        }
        Pagination pagination = new Pagination(
                productQuery.getPageNo(),
                productQuery.getPageSize(),
                productDao.countByExample(productQuery)
        );
        //纠正一下当前页
        productQuery.setPageNo(pagination.getPageNo());
        pagination.setList(productDao.selectByExample(productQuery));
        //分页在页面上展示
        String url = "/product/list.do";
        pagination.pageView(url, params.toString());
        return pagination;
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.SUPPORTS)
    public void insertProduct(Product product) {
        //数据ID 自增长(全国统一商品ID)
        Long id = redisUtil.incr("pno",1L);
        product.setId(id);

        //下架
        product.setIsShow(false);
        //不删除
        product.setIsDel(true);
        //时间
        product.setCreateTime(new Date());
        //保存商品时,返回商品ID
        productDao.insertSelective(product);

        //保存SKU 库存表数据
        for (String color : product.getColors().split(",")) {
            //遍历尺码
            for (String size : product.getSizes().split(",")) {
                Sku sku = new Sku();
                //商品ID
                sku.setProductId(product.getId());
                //颜色ID
                sku.setColorId(Long.parseLong(color));
                //尺码
                sku.setSize(size);
                //市场价
                sku.setMarketPrice(0f);
                //售价
                sku.setPrice(0f);
                //运费
                sku.setDeliveFee(10f);
                //库存
                sku.setStock(0);
                //购买的限购
                sku.setUpperLimit(200);

                //时间
                sku.setCreateTime(new Date());
                //保存
                skuDao.insertSelective(sku);
            }
        }


    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.SUPPORTS)
    public void isShow(Long[] ids) throws IOException, SolrServerException {
        Product product = new Product();
        product.setIsShow(true);
        for (Long id : ids) {
            product.setId(id);
            //修改商品的状态
            productDao.updateByPrimaryKeySelective(product);

            //不在此处进行solr服务器保存商品信息,而是在service-solr中保存,通过activemq发送消息,service-solr接到消息在保存商品到solr服务器
            //activemq可以实现分布式各个service之间的服务解耦
            jmsTemplate.send(new MessageCreator() {
                @Override
                public Message createMessage(Session session) throws JMSException {
                    return session.createTextMessage(String.valueOf(id));
                }
            });



            //静态化
        }
    }

    @Override
    public Product selectProductById(Long productId) {
        return productDao.selectByPrimaryKey(productId);
    }

    @Override
    @Transactional(readOnly = false,propagation = Propagation.SUPPORTS)
    public void updateProduct(Product product) {
        product.setCreateTime(new Date());
        productDao.updateByPrimaryKey(product);

        //删除原有的sku数据
        SkuQuery skuQuery = new SkuQuery();
        skuQuery.createCriteria().andProductIdEqualTo(product.getId());

        skuDao.deleteByExample(skuQuery);

        //重新保存SKU 库存表数据
        List<Sku> list = Lists.newArrayList();
        for (String color : product.getColors().split(",")) {
            for (String size : product.getSizes().split(",")) {
                Sku sku = new Sku();
                //商品ID
                sku.setProductId(product.getId());
                //颜色ID
                sku.setColorId(Long.parseLong(color));
                //尺码
                sku.setSize(size);
                //市场价
                sku.setMarketPrice(0f);
                //售价
                sku.setPrice(0f);
                //运费
                sku.setDeliveFee(10f);
                //库存
                sku.setStock(0);
                //购买的限购
                sku.setUpperLimit(200);

                //时间
                sku.setCreateTime(new Date());
                //保存
                list.add(sku);
            }
        }

        skuDao.insertForeach(list);
        skuDao.insertForeach(list);
    }
}
