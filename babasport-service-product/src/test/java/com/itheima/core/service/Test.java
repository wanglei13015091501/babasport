package com.itheima.core.service;

import com.itheima.common.redis.RedisUtil;
import com.itheima.core.dao.product.ProductDao;
import com.itheima.core.pojo.product.Product;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.common.SolrInputDocument;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * @Auther: wanglei
 * @Date: 2019.08.01
 * @Description: com.itheima
 * @version: 1.0
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:application-context.xml"})
public class Test {
    @Autowired
    private ProductDao productDao;

    @Autowired
    private SolrServer solrServer;

    @Autowired
    private RedisUtil redisUtil;

    @org.junit.Test
    public void  testProduct(){
        Product product = productDao.selectByPrimaryKey(1L);
        System.out.println(product);
    }

    @org.junit.Test
    public  void  testSolr() throws IOException, SolrServerException {
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id","4");
        doc.setField("name","李晨");
        solrServer.add(doc);
        solrServer.commit();
    }

    @org.junit.Test
    public void testRedis(){
        redisUtil.set("key2","value2");
        String value = redisUtil.get("key2").toString();
        redisUtil.delete("key2");
        System.out.println(value);
    }
}
