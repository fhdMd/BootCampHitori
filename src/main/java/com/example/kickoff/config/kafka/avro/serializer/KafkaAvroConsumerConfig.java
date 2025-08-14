package com.example.kickoff.config.kafka.avro.serializer;

import com.example.kickoff.config.kafka.KafkaConfig;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.confluent.kafka.serializers.KafkaAvroDeserializer;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.util.Arrays;
import java.util.Collections;
import java.util.Properties;

@Configuration
public class KafkaAvroConsumerConfig {
    private final KafkaConfig kafkaConfig;
    public KafkaAvroConsumerConfig(KafkaConfig kafkaConfig){
        this.kafkaConfig=kafkaConfig;
    }

    public Properties getProperties(){
        Properties props=new Properties();
        props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfig.getBootstrapAddress());
        props.put(ConsumerConfig.GROUP_ID_CONFIG,"some-group");
        props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class);
        props.put("schema.registry.url","http://localhost:8081");
        props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return props;
    }

    public Consumer<String, GenericRecord> getConsumer(Properties props){
        return new KafkaConsumer<>(props);
    }

    public void consume(){
        Properties props=getProperties();
        Consumer<String,GenericRecord> consumer=getConsumer(props);
        consumer.subscribe(Collections.singletonList("order.created"));
        try {
            while (true) {
                ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofMillis(100));
                for (ConsumerRecord<String, GenericRecord> record : records) {
                    System.out.printf("offset=%d, key=%s, value=%s", record.offset(), record.key(), record.value());
                }
            }
        }
        catch (Exception e) {
            throw new RuntimeException(e);
        }
        finally{
            consumer.close();
        }
    }

}
