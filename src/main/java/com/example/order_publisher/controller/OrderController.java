package com.example.order_publisher.controller;

import com.example.order_publisher.model.CustomerAccount;
import com.example.order_publisher.model.StandingOrder;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class OrderController {

    private final KafkaTemplate<String, StandingOrder> kafkaTemplate;
    private final KafkaTemplate<String, CustomerAccount> accountKafkaTemplate;
    public OrderController(KafkaTemplate<String, StandingOrder> kafkaTemplate,KafkaTemplate<String, CustomerAccount> accountKafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
        this.accountKafkaTemplate = accountKafkaTemplate;
    }

    @PostMapping("/order")
    public ResponseEntity<String> publishOrder(@RequestBody StandingOrder order) {
        kafkaTemplate.send("orders-topic", order.getCustomerId(),order);
        return ResponseEntity.ok("Standing Order published successfully.");
    }

    @PostMapping("/account")
    public ResponseEntity<?> sendAccount(@RequestBody CustomerAccount account) {
        accountKafkaTemplate.send("customer-account-detail-topic", account.getCustomerId(),account);
        return ResponseEntity.ok("Standing Order published successfully.");
    }
}
