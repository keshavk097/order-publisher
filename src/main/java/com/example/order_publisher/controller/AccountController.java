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
@RequestMapping("/api/account")
public class AccountController {
    private final KafkaTemplate<String, CustomerAccount> kafkaTemplate;

    public AccountController(KafkaTemplate<String, CustomerAccount> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping("/publish")
    public ResponseEntity<?> sendAccount(@RequestBody CustomerAccount account) {
        kafkaTemplate.send("customer-account-detail-topic", account.getCustomerId(),account);
        return ResponseEntity.ok("Standing Order published successfully.");
    }
}
