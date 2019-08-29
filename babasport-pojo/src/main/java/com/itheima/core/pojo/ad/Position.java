package com.itheima.core.pojo.ad;

public class Position {
    private Long id;

    private Long parentId;

    private String name;

    private Integer sort;

    private Boolean isParent;

    private Boolean isEnable;

    public Position(Long id, Long parentId, String name, Integer sort, Boolean isParent, Boolean isEnable) {
        this.id = id;
        this.parentId = parentId;
        this.name = name;
        this.sort = sort;
        this.isParent = isParent;
        this.isEnable = isEnable;
    }

    public Position() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Boolean getIsParent() {
        return isParent;
    }

    public void setIsParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public Boolean getIsEnable() {
        return isEnable;
    }

    public void setIsEnable(Boolean isEnable) {
        this.isEnable = isEnable;
    }
}