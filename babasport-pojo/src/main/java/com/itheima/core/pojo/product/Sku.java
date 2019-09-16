package com.itheima.core.pojo.product;

import java.util.Date;

public class Sku {
    private Long id;

    private Long productId;

    private Long colorId;

    private String size;

    private Float marketPrice;

    private Float price;

    private Float deliveFee;

    private Integer stock;

    private Integer upperLimit;

    private Date createTime;

    //附加对象
    private Color color;

    public Sku(Long id, Long productId, Long colorId, String size, Float marketPrice, Float price, Float deliveFee, Integer stock, Integer upperLimit, Date createTime) {
        this.id = id;
        this.productId = productId;
        this.colorId = colorId;
        this.size = size;
        this.marketPrice = marketPrice;
        this.price = price;
        this.deliveFee = deliveFee;
        this.stock = stock;
        this.upperLimit = upperLimit;
        this.createTime = createTime;
    }

    public Sku() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Long getColorId() {
        return colorId;
    }

    public void setColorId(Long colorId) {
        this.colorId = colorId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size == null ? null : size.trim();
    }

    public Float getMarketPrice() {
        return marketPrice;
    }

    public void setMarketPrice(Float marketPrice) {
        this.marketPrice = marketPrice;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getDeliveFee() {
        return deliveFee;
    }

    public void setDeliveFee(Float deliveFee) {
        this.deliveFee = deliveFee;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getUpperLimit() {
        return upperLimit;
    }

    public void setUpperLimit(Integer upperLimit) {
        this.upperLimit = upperLimit;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}