package com.springPrac.springredisdemo.Config;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class Kafka_Config {

    private Map<String,Object> properties=new HashMap<>();

    @Bean
    public ProducerFactory<Long,Object> applicationProducerFactory() {
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        properties.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, 30);
        properties.put(ProducerConfig.BATCH_SIZE_CONFIG,5);
        ProducerFactory<Long,Object> pf=new DefaultKafkaProducerFactory<Long,Object>(properties);
        return pf;
    }
    @Bean
    public KafkaTemplate<Long,Object> kafkaTemplate(){
        KafkaTemplate<Long,Object> kfTemplate=new KafkaTemplate<Long,Object>(applicationProducerFactory());
        return kfTemplate;
    }

}
