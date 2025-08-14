package com.example.kickoff.controller.kafka.avro;

import com.example.kickoff.config.kafka.avro.serializer.KafkaAvroConsumerConfig;
import com.example.kickoff.config.kafka.avro.serializer.KafkaAvroProducerConfig;
import com.example.kickoff.model.Order;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/avro")
public class KafkaAvroController {

    private final KafkaAvroProducerConfig kafkaAvroProducerConfig;
    private final KafkaAvroConsumerConfig kafkaAvroConsumerConfig;

    public KafkaAvroController(KafkaAvroProducerConfig kafkaAvroProducerConfig,KafkaAvroConsumerConfig kafkaAvroConsumerConfig){
        this.kafkaAvroProducerConfig=kafkaAvroProducerConfig;
        this.kafkaAvroConsumerConfig=kafkaAvroConsumerConfig;
    }

    @PostMapping("/{id}")
    public String send(@PathVariable("id") int orderId){
        return kafkaAvroProducerConfig.send(new Order(orderId));
    }

    @GetMapping
    public String consume(){
        kafkaAvroConsumerConfig.consume();
        return "Consumed";
    }
}
