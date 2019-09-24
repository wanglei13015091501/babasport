package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @Auther: wanglei
 * @Date: 2019.09.24
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 6517943370948820978L;
    private Long id;
    private List<Role> roleList;
    private List<Permission> permissionList;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Role> getRoleList() {
        return roleList;
    }

    public void setRoleList(List<Role> roleList) {
        this.roleList = roleList;
    }

    public List<Permission> getPermissionList() {
        return permissionList;
    }

    public void setPermissionList(List<Permission> permissionList) {
        this.permissionList = permissionList;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "RolePermission{" +
                "id=" + id +
                ", roleList=" + roleList +
                ", permissionList=" + permissionList +
                ", created=" + created +
                '}';
    }
}
