package com.itheima.core.dao.product;


import com.itheima.core.pojo.product.Color;
import com.itheima.core.pojo.product.ColorQuery;

import java.util.List;

public interface ColorDao {
    int deleteByPrimaryKey(Long id);

    int insert(Color record);

    int insertSelective(Color record);

    Color selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Color record);

    int updateByPrimaryKey(Color record);

    List<Color> selectByExample(ColorQuery colorQuery);
}