package com.itheima.core.dao.order;


import com.itheima.core.pojo.order.Order;

public interface OrderDao {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}