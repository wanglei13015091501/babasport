package com.itheima.core.dao.order;


import com.itheima.core.pojo.order.Detail;

public interface DetailDao {
    int deleteByPrimaryKey(Long id);

    int insert(Detail record);

    int insertSelective(Detail record);

    Detail selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Detail record);

    int updateByPrimaryKey(Detail record);
}