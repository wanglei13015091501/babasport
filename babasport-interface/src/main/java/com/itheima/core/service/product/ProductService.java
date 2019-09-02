package com.itheima.core.service.product;

import com.itheima.common.page.Pagination;
import com.itheima.core.pojo.product.Product;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

/**
 * @Auther: wanglei
 * @Date: 2019.08.02
 * @Description: com.itheima.core.service
 * @version: 1.0
 */
public interface ProductService {

    Pagination selectProList(Integer pageNo, String name, Long brandId, Boolean isShow);

    void insertProduct(Product product);

    void isShow(Long[] ids) throws IOException, SolrServerException;

    Product selectProductById(Long productId);

    void updateProduct(Product product);
}
