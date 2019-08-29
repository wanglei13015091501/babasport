package com.itheima.core.pojo.order;

import java.util.Date;

public class Order {
    private Long id;

    private Float deliverFee;

    private Float totalPrice;

    private Float orderPrice;

    private Boolean paymentWay;

    private Boolean paymentCash;

    private Boolean delivery;

    private Boolean isConfirm;

    private Boolean isPaiy;

    private Boolean orderState;

    private Date createDate;

    private String note;

    private Long buyerId;

    public Order(Long id, Float deliverFee, Float totalPrice, Float orderPrice, Boolean paymentWay, Boolean paymentCash, Boolean delivery, Boolean isConfirm, Boolean isPaiy, Boolean orderState, Date createDate, String note, Long buyerId) {
        this.id = id;
        this.deliverFee = deliverFee;
        this.totalPrice = totalPrice;
        this.orderPrice = orderPrice;
        this.paymentWay = paymentWay;
        this.paymentCash = paymentCash;
        this.delivery = delivery;
        this.isConfirm = isConfirm;
        this.isPaiy = isPaiy;
        this.orderState = orderState;
        this.createDate = createDate;
        this.note = note;
        this.buyerId = buyerId;
    }

    public Order() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getDeliverFee() {
        return deliverFee;
    }

    public void setDeliverFee(Float deliverFee) {
        this.deliverFee = deliverFee;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Float getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Float orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Boolean getPaymentWay() {
        return paymentWay;
    }

    public void setPaymentWay(Boolean paymentWay) {
        this.paymentWay = paymentWay;
    }

    public Boolean getPaymentCash() {
        return paymentCash;
    }

    public void setPaymentCash(Boolean paymentCash) {
        this.paymentCash = paymentCash;
    }

    public Boolean getDelivery() {
        return delivery;
    }

    public void setDelivery(Boolean delivery) {
        this.delivery = delivery;
    }

    public Boolean getIsConfirm() {
        return isConfirm;
    }

    public void setIsConfirm(Boolean isConfirm) {
        this.isConfirm = isConfirm;
    }

    public Boolean getIsPaiy() {
        return isPaiy;
    }

    public void setIsPaiy(Boolean isPaiy) {
        this.isPaiy = isPaiy;
    }

    public Boolean getOrderState() {
        return orderState;
    }

    public void setOrderState(Boolean orderState) {
        this.orderState = orderState;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
}