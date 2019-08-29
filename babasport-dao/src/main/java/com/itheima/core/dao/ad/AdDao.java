package com.itheima.core.dao.ad;


import com.itheima.core.pojo.ad.Ad;

public interface AdDao {
    int deleteByPrimaryKey(Long id);

    int insert(Ad record);

    int insertSelective(Ad record);

    Ad selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Ad record);

    int updateByPrimaryKey(Ad record);
}