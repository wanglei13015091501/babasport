package com.itheima.core.service;

import com.itheima.common.page.Pagination;
import com.itheima.core.service.solr.SolrService;
import org.apache.solr.client.solrj.SolrServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    public Pagination selectPaginationByQuery(){
        return new Pagination();
    }
}
