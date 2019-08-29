package com.itheima.core.test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

/**
 * @Auther: wanglei
 * @Date: 2019.08.28
 * @Description: com.itheima
 * @version: 1.0
 */

public class testSolr {
    @Test
    public  void  testSolr() throws IOException, SolrServerException {
        //1.创建HttpSolrServer对象，既solr服务器接口
        String baseURL = "http://10.126.33.46:8080/solr";
        SolrServer solrServer = new HttpSolrServer(baseURL);

        //2.创建
        SolrInputDocument doc = new SolrInputDocument();
        doc.setField("id","3");
        doc.setField("name","范冰冰");
        solrServer.add(doc);
        solrServer.commit();
    }
}
