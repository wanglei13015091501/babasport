package com.itheima.core.dao.sso;

import com.itheima.core.pojo.sso.Menu;
import com.itheima.core.pojo.sso.Role;
import com.itheima.core.pojo.sso.RoleMenu;

import java.util.List;

public interface RoleMenuDao {
    int deleteByPrimaryKey(Long id);

    int insert(RoleMenu record);

    int insertSelective(RoleMenu record);

    RoleMenu selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(RoleMenu record);

    int updateByPrimaryKey(RoleMenu record);

    List<Role> getRolesByMenuId(Long menuId);

    List<Menu> getMenusByRoleId(Long roleId);

}