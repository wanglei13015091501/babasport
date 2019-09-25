package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wanglei
 * @Date: 2019.09.24
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class RolePermission implements Serializable {

    private static final long serialVersionUID = 6517943370948820978L;
    private Long id;
    private Long roleId;
    private Long permissionId;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Long permissionId) {
        this.permissionId = permissionId;
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
                ", roleId=" + roleId +
                ", permissionId=" + permissionId +
                ", created=" + created +
                '}';
    }
}
