package com.itheima.core.dao;

import com.itheima.core.pojo.menu;
import com.itheima.core.pojo.menuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface menuMapper {
    int countByExample(menuExample example);

    int deleteByExample(menuExample example);

    int deleteByPrimaryKey(Long id);

    int insert(menu record);

    int insertSelective(menu record);

    List<menu> selectByExample(menuExample example);

    menu selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") menu record, @Param("example") menuExample example);

    int updateByExample(@Param("record") menu record, @Param("example") menuExample example);

    int updateByPrimaryKeySelective(menu record);

    int updateByPrimaryKey(menu record);
}