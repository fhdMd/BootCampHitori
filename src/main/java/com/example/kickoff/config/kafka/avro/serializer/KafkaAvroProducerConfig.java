package com.example.kickoff.config.kafka.avro.serializer;

import com.example.kickoff.config.kafka.KafkaConfig;
import com.example.kickoff.model.Order;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import io.confluent.kafka.serializers.KafkaAvroSerializer;
import org.apache.avro.Schema;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Time;
import java.time.LocalDateTime;
import java.util.Properties;

@Configuration
public class KafkaAvroProducerConfig {

    private final Properties properties;
    private final KafkaConfig kafkaConfig;

    String key="someKey";
    String schema= "{\"type\": \"record\"," +
            "\"name\": \"OrderCreatedEvent\", " +
            "\"fields\": " +
            "[{\"name\": \"orderId\",\"type\": \"int\"}," +
            "{\"name\": \"status\",\"type\": \"string\"}," +
            "{\"name\": \"createdTime\",\"type\": \"string\"}]}";

    public KafkaAvroProducerConfig(Properties properties, KafkaConfig kafkaConfig){
        this.properties=properties;
        this.kafkaConfig=kafkaConfig;
    }


    public String send(Order order){
        Properties properties=getProperties();
        Schema schemaDef=getSchema(schema);
        GenericRecord genericRecord=getGenericRecord(schemaDef,order.getOrderId(),order.getStatus(),order.getTime());
        ProducerRecord<Object, Object> record = getRecord(genericRecord);
        KafkaProducer kafkaProducer=getProducer(properties);
        try{
            kafkaProducer.send(record);
        } catch (RuntimeException e) {
            throw new RuntimeException(e);
        }
        finally {
            kafkaProducer.flush();
            kafkaProducer.close();
        }
        return "Sent successfully";
    }

    public Properties getProperties(){
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,kafkaConfig.getBootstrapAddress());
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class);
        properties.put("schema.registry.url","http://localhost:8081");
        return properties;
    }

    public Schema getSchema(String schemaDef){
        Schema.Parser parser=new Schema.Parser();
        return parser.parse(schemaDef);
    }


    public GenericRecord getGenericRecord(Schema schema,int orderId,String status,String time){
        GenericRecord record=new GenericData.Record(schema);
        record.put("orderId",orderId);
        record.put("status",status);
        record.put("createdTime",time);
        return record;
    }

    public ProducerRecord<Object,Object> getRecord(GenericRecord record){
        return new ProducerRecord<>("order.created",key,record);
    }

    public KafkaProducer getProducer(Properties properties){
        return new KafkaProducer(properties);
    }

}
