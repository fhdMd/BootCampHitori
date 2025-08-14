package com.example.kickoff.model;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

public class Order {
    private int orderId;
    private String status;
    private String time;

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

    public String getTime() {
        return time.toString();
    }

    public void setTime(LocalDateTime time) {
        this.time = time.toString();
    }

    public Order(int orderId) {
        this.orderId = orderId;
        this.status="CREATED";
        this.time=LocalDateTime.now().toString();
    }

    public Order() {
    }
}
