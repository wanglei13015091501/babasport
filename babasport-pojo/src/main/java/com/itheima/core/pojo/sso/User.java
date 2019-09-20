package com.itheima.core.pojo.sso;

import java.io.Serializable;
import java.util.Date;

/**
 * @Auther: wanglei
 * @Date: 2019.09.20
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class User implements Serializable {
    private static final long serialVersionUID = 8919923828880129877L;

    private Long id; // 主键
    private Date birthday; // 生日
    private String gender; // 性别
    private String password; // 密码
    private String remark; // 备注
    private String station; // 状态
    private String telephone; // 联系电话
    private String username; // 登陆用户名
    private String nickname;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", password='" + password + '\'' +
                ", remark='" + remark + '\'' +
                ", station='" + station + '\'' +
                ", telephone='" + telephone + '\'' +
                ", username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
