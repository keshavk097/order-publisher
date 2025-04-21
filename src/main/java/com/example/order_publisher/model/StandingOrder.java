package com.example.order_publisher.model;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StandingOrder {

    private String orderId;

    private String customerId;

    private String accountNumber;

    private String sortCode;

    private Double amount;

    private String frequency;

   // private LocalDate nextExecutionDate;

   // private String status;

    private LocalDate startDate;
    private LocalDate endDate;

}