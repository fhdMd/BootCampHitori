package com.example.kickoff.controller;

import com.example.kickoff.config.kafka.KafkaConfig;
import com.example.kickoff.config.kafka.KafkaProducerConfig;
import com.example.kickoff.model.Order;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class KafkaController {

    private final KafkaTemplate<String,Order> kafkaTemplate;
    private final NewTopic topic;

    public KafkaController(KafkaProducerConfig kafkaProducerConfig,KafkaConfig kafkaConfig){
        this.kafkaTemplate=kafkaProducerConfig.kafkaTemplate();
        this.topic=kafkaConfig.createTopic();
    }
    @PostMapping("/{id}")
    public String send(@PathVariable("id") int orderId){
        kafkaTemplate.send(topic.name(),new Order(orderId));
        return "Order Created in Kafka Topic";
    }

    @KafkaListener(topics="order.created",groupId = "1")
    public void read(String message){
        System.out.println("Got message "+message);
    }


}
