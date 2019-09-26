package com.itheima.core.dao;

import com.itheima.core.pojo.permission;
import com.itheima.core.pojo.permissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface permissionMapper {
    int countByExample(permissionExample example);

    int deleteByExample(permissionExample example);

    int deleteByPrimaryKey(Long id);

    int insert(permission record);

    int insertSelective(permission record);

    List<permission> selectByExample(permissionExample example);

    permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") permission record, @Param("example") permissionExample example);

    int updateByExample(@Param("record") permission record, @Param("example") permissionExample example);

    int updateByPrimaryKeySelective(permission record);

    int updateByPrimaryKey(permission record);
}