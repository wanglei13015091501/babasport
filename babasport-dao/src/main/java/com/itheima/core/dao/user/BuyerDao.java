package com.itheima.core.dao.user;


import com.itheima.core.pojo.user.Buyer;

public interface BuyerDao {
    int deleteByPrimaryKey(Long id);

    int insert(Buyer record);

    int insertSelective(Buyer record);

    Buyer selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Buyer record);

    int updateByPrimaryKey(Buyer record);
}