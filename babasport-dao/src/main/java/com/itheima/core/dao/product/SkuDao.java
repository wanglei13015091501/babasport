package com.itheima.core.dao.product;


import com.itheima.core.pojo.product.Sku;
import com.itheima.core.pojo.product.SkuQuery;

import java.util.List;

public interface SkuDao {
    int deleteByPrimaryKey(Long id);

    int insert(Sku record);

    int insertSelective(Sku record);

    Sku selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sku record);

    int updateByPrimaryKey(Sku record);

    List<Sku> selectByExample(SkuQuery skuQuery);
}