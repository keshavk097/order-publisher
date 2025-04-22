package com.example.order_publisher.model;

import lombok.Data;

@Data
public class CustomerAccount {
    private String customerId;
    private String accountNumber;
    private String name;
    private Double accountBalance;
}
