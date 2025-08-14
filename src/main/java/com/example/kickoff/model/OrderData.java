package com.example.kickoff.model;

import java.time.LocalDateTime;

public class OrderData {
    private String customerInfo;
    private String orderInfo;
    private int orderNumberInfo;
    private LocalDateTime createdTime;
    public OrderData() {
        createdTime=LocalDateTime.now();
    }

    public OrderData(String customerInfo, String orderInfo) {
        this();
        this.customerInfo = customerInfo;
        this.orderInfo = orderInfo;
    }

    public OrderData(String customerInfo, String orderInfo, int orderNumberInfo) {
        this();
        this.customerInfo = customerInfo;
        this.orderInfo = orderInfo;
        this.orderNumberInfo = orderNumberInfo;
    }

    public String getCustomerInfo() {
        return customerInfo;
    }

    public void setCustomerInfo(String customerInfo) {
        this.customerInfo = customerInfo;
    }

    public String getOrderInfo() {
        return orderInfo;
    }

    public void setOrderInfo(String orderInfo) {
        this.orderInfo = orderInfo;
    }

    public int getOrderNumberInfo() {
        return orderNumberInfo;
    }

    public void setOrderNumberInfo(int orderNumberInfo) {
        this.orderNumberInfo = orderNumberInfo;
    }

    public LocalDateTime getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(LocalDateTime createdTime) {
        this.createdTime = createdTime;
    }
}
