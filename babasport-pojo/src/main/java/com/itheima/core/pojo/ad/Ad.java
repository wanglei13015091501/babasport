package com.itheima.core.pojo.ad;

public class Ad {
    private Long id;

    private Long positionId;

    private String title;

    private String url;

    private String picture;

    private Integer height;

    private Integer width;

    public Ad(Long id, Long positionId, String title, String url, String picture, Integer height, Integer width) {
        this.id = id;
        this.positionId = positionId;
        this.title = title;
        this.url = url;
        this.picture = picture;
        this.height = height;
        this.width = width;
    }

    public Ad() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture == null ? null : picture.trim();
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }
}