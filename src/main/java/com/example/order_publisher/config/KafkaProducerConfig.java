package com.example.order_publisher.config;

import com.example.order_publisher.model.CustomerAccount;
import com.example.order_publisher.model.StandingOrder;
import com.example.order_publisher.serdes.CustomerAccountSerializer;
import com.example.order_publisher.serdes.OrderSerializer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.*;

import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public ProducerFactory<String, StandingOrder> producerFactory() {
        return new DefaultKafkaProducerFactory<>(
                Map.of(
                        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "my-kafka-kafka-bootstrap.kafka.svc:9092",
                        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, OrderSerializer.class
                )
        );
    }

    @Bean
    public KafkaTemplate<String, StandingOrder> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, CustomerAccount> accountProducerFactory() {
        return new DefaultKafkaProducerFactory<>(
                Map.of(
                        ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "my-kafka-kafka-bootstrap.kafka.svc:9092",
                        ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class,
                        ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomerAccountSerializer.class
                )
        );
    }

    @Bean
    public KafkaTemplate<String, CustomerAccount> accountKafkaTemplate() {
        return new KafkaTemplate<>(accountProducerFactory());
    }
}
