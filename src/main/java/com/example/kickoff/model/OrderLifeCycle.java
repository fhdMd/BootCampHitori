package com.example.kickoff.model;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.Map;

@Document(collection = "order_lifecycle")
public class OrderLifeCycle{
    @Id
    private String id;
    private String orderId;
    private String orderEvent;
    private OrderData orderData;
    private LocalDateTime currentTime;
    private LocalDateTime updatedTime;

    public OrderLifeCycle() {
        this.currentTime=LocalDateTime.now();
        this.updatedTime=LocalDateTime.now();
    }

    public OrderLifeCycle(String id) {
        this();
        this.orderId = id;
    }

    public OrderLifeCycle(String orderEvent, OrderData orderData, LocalDateTime currentTime, LocalDateTime updatedTime) {
        this.orderEvent = orderEvent;
        this.orderData = orderData;
        this.currentTime = currentTime;
        this.updatedTime = updatedTime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getOrderEvent() {
        return orderEvent;
    }

    public LocalDateTime getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(LocalDateTime currentTime) {
        this.currentTime = currentTime;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }

    public void setOrderEvent(String orderEvent) {
        this.orderEvent = orderEvent;
    }

    public OrderData getOrderData() {
        return orderData;
    }

    public void setOrderData(OrderData orderData) {
        this.orderData = orderData;
    }
}
