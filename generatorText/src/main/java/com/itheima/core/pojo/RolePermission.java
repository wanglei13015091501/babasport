package com.itheima.core.pojo;

import java.io.Serializable;
import java.util.Date;

public class RolePermission implements Serializable {
    private Long id;

    private Long role_id;

    private Long permission_id;

    private Date created;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRole_id() {
        return role_id;
    }

    public void setRole_id(Long role_id) {
        this.role_id = role_id;
    }

    public Long getPermission_id() {
        return permission_id;
    }

    public void setPermission_id(Long permission_id) {
        this.permission_id = permission_id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}