package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.20
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class Role implements Serializable {
    private static final long serialVersionUID = -1481939504970011136L;
    private Long id;
    private String name; // 角色名称
    private String keyword; // 角色关键字，用于权限控制
    private String description; // 描述
    private String status; // 状态

    private List<User> userList;//角色对应的用户,多对多
    private List<Permission> permissionList;//角色对应的权限,多对多
    private List<Menu> menuList;//菜单对应的权限,多对多

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public List<Menu> getMenuList() {
        return menuList;
    }

    public void setMenuList(List<Menu> menuList) {
        this.menuList = menuList;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", userList=" + userList +
                ", permissionList=" + permissionList +
                ", menuList=" + menuList +
                '}';
    }
}
