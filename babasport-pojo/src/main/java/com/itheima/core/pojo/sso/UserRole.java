package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wanglei
 *
 * @Date: 2019.09.24
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class UserRole implements Serializable {
    private static final long serialVersionUID = -1532998430689384086L;
    private Long id;
    private Long roleId;
    private Long userId;
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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "id=" + id +
                ", roleId=" + roleId +
                ", userId=" + userId +
                ", created=" + created +
                '}';
    }
}
