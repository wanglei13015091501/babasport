package com.itheima.core.dao.sso;

import com.itheima.core.pojo.product.Product;
import com.itheima.core.pojo.product.ProductQuery;

import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.24
 * @Description: com.itheima.core.dao.sso
 * @version: 1.0
 */
public interface UserDao {

    int deleteByPrimaryKey(Long id);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    int countByExample(ProductQuery productQuery);

    List selectByExample(ProductQuery productQuery);
}
