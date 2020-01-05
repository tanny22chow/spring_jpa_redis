package com.springPrac.springredisdemo.Config;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
public class Kafka_Config {

    private Map<String,Object> properties=new HashMap<>();

    @Bean
    public ProducerFactory<Long,Object> applicationProducerFactory() {
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9091");
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
	@Bean
	public ConsumerFactory consumerfactory() {
		Map<String,Object>mapconfiguration= new HashMap<String,Object>();
		mapconfiguration.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9091");
		mapconfiguration.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		mapconfiguration.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
		mapconfiguration.put(ConsumerConfig.EXCLUDE_INTERNAL_TOPICS_CONFIG, true);
		mapconfiguration.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG,false);
		mapconfiguration.put(ConsumerConfig.GROUP_ID_CONFIG,"verification_service");
		mapconfiguration.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"latest");
		ConsumerFactory<String,String> applicantInfofactory=new DefaultKafkaConsumerFactory<String,String>(
				mapconfiguration,new StringDeserializer(),
				//new JsonDeserializer<>(ApplicantDTO.class,false));
				new StringDeserializer());
		return applicantInfofactory;
	}
	@Bean
	public ConcurrentKafkaListenerContainerFactory<String,String> applicantserviceContainer() {
		ConcurrentKafkaListenerContainerFactory<String,String> containerfactory= 
				new ConcurrentKafkaListenerContainerFactory<String,String>();
		containerfactory.setConcurrency(3);
		containerfactory.setConsumerFactory(consumerfactory());
		return containerfactory;
	}

}
