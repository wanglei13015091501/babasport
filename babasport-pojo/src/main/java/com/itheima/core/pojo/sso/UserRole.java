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
public class UserRole implements Serializable {
    private static final long serialVersionUID = -1532998430689384086L;
    private Long id;
    private List<Role> roleList;
    private List<User> userList;
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

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
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
                ", roleList=" + roleList +
                ", userList=" + userList +
                ", created=" + created +
                '}';
    }
}
