package com.example.order_publisher.controller;

import com.example.order_publisher.model.StandingOrder;
import com.example.order_publisher.service.OrderProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/standing-orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderProducer producer;

    @PostMapping("/publish")
    public ResponseEntity<String> publishOrder(@RequestBody StandingOrder order) {
        producer.publish(order);
        return ResponseEntity.ok("Standing Order published successfully.");
    }
}
