package com.itheima.core.dao.ad;


import com.itheima.core.pojo.ad.Position;

public interface PositionDao {
    int deleteByPrimaryKey(Long id);

    int insert(Position record);

    int insertSelective(Position record);

    Position selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Position record);

    int updateByPrimaryKey(Position record);
}