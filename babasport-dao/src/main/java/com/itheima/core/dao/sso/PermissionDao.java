package com.itheima.core.dao.sso;

import com.itheima.core.pojo.sso.Permission;
import com.itheima.core.pojo.sso.PermissionQuery;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PermissionDao {
    int countByExample(PermissionQuery example);

    int deleteByExample(PermissionQuery example);

    int deleteByPrimaryKey(Long id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionQuery example);

    Permission selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByExample(@Param("record") Permission record, @Param("example") PermissionQuery example);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}