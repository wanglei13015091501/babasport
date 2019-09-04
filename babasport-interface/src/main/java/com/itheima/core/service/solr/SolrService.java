package com.itheima.core.service.solr;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Brand;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.08.29
 * @Description: com.itheima.core.service.solr
 * @version: 1.0
 */
public interface SolrService {

    Pagination selectPaginationByQuery(Integer pageNo, String keyword) throws Exception;

    List<Brand> selectBrandList();
}