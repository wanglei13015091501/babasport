package com.itheima.core.service;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.ProductQuery;
import com.itheima.core.service.solr.SolrService;
import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
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

    public Pagination selectPaginationByQuery(Integer pageNo,String keyword,Long brandId,String price){
        //商品对象Query
        ProductQuery productQuery = new ProductQuery();
        //当前页
        productQuery.setPageNo(Pagination.cpn(pageNo));
        //每页数
        productQuery.setPageSize(8);
        SolrQuery solrQuery = new SolrQuery();

        //条件
        if(StringUtils.isNotBlank(keyword)){
            //关键词
        }


        return new Pagination();
    }
}
