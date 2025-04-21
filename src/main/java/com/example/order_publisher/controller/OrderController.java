package com.example.order_publisher.controller;

import com.example.order_publisher.model.StandingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/standing-orders")
public class OrderController {

    private final KafkaTemplate<String, StandingOrder> kafkaTemplate;

    public OrderController(KafkaTemplate<String, StandingOrder> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<String> publishOrder(@RequestBody StandingOrder order) {
        kafkaTemplate.send("orders-topic", order.getOrderId(),order);
        return ResponseEntity.ok("Standing Order published successfully.");
    }
}
