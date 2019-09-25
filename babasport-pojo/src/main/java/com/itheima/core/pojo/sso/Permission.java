package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.20
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class Permission implements Serializable {

    private static final long serialVersionUID = 3223572325909403029L;

    private Long id;
    private String name; // 权限名称
    private String keyword; // 权限关键字，用于权限控制
    private String description; // 描述
    private String status; // 状态

    private List<Role> roleList;//当前权限对应的角色

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

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    @Override
    public String toString() {
        return "Permission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", keyword='" + keyword + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", roleList=" + roleList +
                '}';
    }
}
