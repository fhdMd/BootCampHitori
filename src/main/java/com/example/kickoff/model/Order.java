package com.example.kickoff.model;

public class Order {
    private int orderId;
    private String status;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(int orderId) {
        this.orderId = orderId;
        this.status="CREATED";
    }
}
