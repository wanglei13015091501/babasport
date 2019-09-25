package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wanglei
 * @Date: 2019.09.24
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class RoleMenu implements Serializable {
    private static final long serialVersionUID = 4742805899248254482L;

    private Long id;
    private Long menuId;
    private Long roleId;
    private Date created;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "RoleMenu{" +
                "id=" + id +
                ", menuId=" + menuId +
                ", roleId=" + roleId +
                ", created=" + created +
                '}';
    }
}
