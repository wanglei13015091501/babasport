package com.itheima.core.dao.product;


import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.ProductQuery;

import java.util.List;

public interface ProductDao {
    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int countByExample(ProductQuery productQuery);

    List selectByExample(ProductQuery productQuery);
}