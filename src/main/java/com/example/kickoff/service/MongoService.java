package com.example.kickoff.service;

import com.example.kickoff.model.OrderData;
import com.example.kickoff.model.OrderLifeCycle;
import com.example.kickoff.repo.MongoRepo;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

    private final MongoRepo mongoRepo;

    public MongoService(MongoRepo mongoRepo){
        this.mongoRepo=mongoRepo;
    }


    public void addEvent(String orderId, OrderLifeCycle orderLifeCycle) {
        orderLifeCycle.setOrderId(orderId);
        mongoRepo.save(orderLifeCycle);
    }
}
