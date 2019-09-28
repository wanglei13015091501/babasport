package com.itheima.core.dao.sso;

import com.itheima.core.pojo.sso.Role;
import com.itheima.core.pojo.sso.User;
import com.itheima.core.pojo.sso.UserRole;

import java.util.List;

public interface UserRoleDao {
    int deleteByPrimaryKey(Long id);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    List<Role> getRolesByUserId(Long userId);

    List<User> getUsersByRoleId(Long roleId);
}