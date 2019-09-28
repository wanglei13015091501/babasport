package com.itheima.core.dao.sso;

import com.itheima.core.pojo.sso.Permission;
import com.itheima.core.pojo.sso.Role;
import com.itheima.core.pojo.sso.RolePermission;

import java.util.List;

public interface RolePermissionDao {
    int deleteByPrimaryKey(Long id);

    int insert(RolePermission record);

    int insertSelective(RolePermission record);

    RolePermission selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RolePermission record);

    int updateByPrimaryKey(RolePermission record);

    List<Role> getRolesByPermissionId(Long permissionId);

    List<Permission> getPermissionsByRoleId(Long roleId);
}