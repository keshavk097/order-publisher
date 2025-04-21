package com.example.order_publisher.service;

import com.example.order_publisher.model.StandingOrder;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderProducer {

    private final KafkaTemplate<String, StandingOrder> kafkaTemplate;
    private final String topic = "orders-topic";

    public void publish(StandingOrder order) {
       kafkaTemplate.send(topic,order.getOrderId() , order);
    }
}