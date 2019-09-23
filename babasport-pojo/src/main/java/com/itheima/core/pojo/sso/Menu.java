package com.itheima.core.pojo.sso;

import java.io.Serializable;

/**
 * @Auther: wanglei
 * @Date: 2019.09.20
 * @Description: com.itheima.core.pojo.sso
 * @version: 1.0
 */
public class Menu implements Serializable {

    private static final long serialVersionUID = -7015104047305416970L;
    private Long id;
    private String name; // 菜单名称
    private String page; // 访问路径
    private Integer priority; // 优先级
    private String description; // 描述
    private Long pid;//父菜单


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


    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", page='" + page + '\'' +
                ", priority=" + priority +
                ", description='" + description + '\'' +
                ", pid=" + pid +
                '}';
    }
}
