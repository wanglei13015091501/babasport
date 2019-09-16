package com.itheima.core.service.cms;

import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.Sku;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.16
 * @Description: com.itheima.core.service.cms
 * @version: 1.0
 */
public interface CmsService {

    Product selectProductById(Long id);

    List<Sku> selectSkuListByProductId(Long id);
}
