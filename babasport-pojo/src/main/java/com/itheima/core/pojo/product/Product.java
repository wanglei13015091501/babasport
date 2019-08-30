package com.itheima.core.pojo.product;

import java.io.Serializable;
import java.util.Date;

public class Product implements Serializable {
    private static final long serialVersionUID = 3206426041371383564L;
    private Long id;

    private Long brandId;

    private String name;

    private Float weight;

    private Boolean isNew;

    private Boolean isHot;

    private Boolean isCommend;

    private Boolean isShow;

    private Boolean isDel;

    private String description;

    private String packageList;

    private String colors;

    private String sizes;

    private Date createTime;

    private String imgUrl;

    private Float price;

    public  String[] getImages(){
        return imgUrl.split(",");
    }


    public Product(Long id, Long brandId, String name, Float weight, Boolean isNew, Boolean isHot, Boolean isCommend, Boolean isShow, Boolean isDel, String description, String packageList, String colors, String sizes, Date createTime, String imgUrl) {
        this.id = id;
        this.brandId = brandId;
        this.name = name;
        this.weight = weight;
        this.isNew = isNew;
        this.isHot = isHot;
        this.isCommend = isCommend;
        this.isShow = isShow;
        this.isDel = isDel;
        this.description = description;
        this.packageList = packageList;
        this.colors = colors;
        this.sizes = sizes;
        this.createTime = createTime;
        this.imgUrl = imgUrl;
    }

    public Product() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Boolean getIsNew() {
        return isNew;
    }

    public void setIsNew(Boolean isNew) {
        this.isNew = isNew;
    }

    public Boolean getIsHot() {
        return isHot;
    }

    public void setIsHot(Boolean isHot) {
        this.isHot = isHot;
    }

    public Boolean getIsCommend() {
        return isCommend;
    }

    public void setIsCommend(Boolean isCommend) {
        this.isCommend = isCommend;
    }

    public Boolean getIsShow() {
        return isShow;
    }

    public void setIsShow(Boolean isShow) {
        this.isShow = isShow;
    }

    public Boolean getIsDel() {
        return isDel;
    }

    public void setIsDel(Boolean isDel) {
        this.isDel = isDel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getPackageList() {
        return packageList;
    }

    public void setPackageList(String packageList) {
        this.packageList = packageList == null ? null : packageList.trim();
    }

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors == null ? null : colors.trim();
    }

    public String getSizes() {
        return sizes;
    }

    public void setSizes(String sizes) {
        this.sizes = sizes == null ? null : sizes.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", brandId=" + brandId +
                ", name='" + name + '\'' +
                ", weight=" + weight +
                ", isNew=" + isNew +
                ", isHot=" + isHot +
                ", isCommend=" + isCommend +
                ", isShow=" + isShow +
                ", isDel=" + isDel +
                ", description='" + description + '\'' +
                ", packageList='" + packageList + '\'' +
                ", colors='" + colors + '\'' +
                ", sizes='" + sizes + '\'' +
                ", createTime=" + createTime +
                ", imgUrl='" + imgUrl + '\'' +
                '}';
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }
}