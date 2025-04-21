package com.example.order_publisher.model;

import com.example.order_publisher.serdes.LocalDateSerializer;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
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
   @JsonFormat(pattern = "yyyy-MM-dd") // Optional: Specify the format for LocalDate
   @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate startDate;

    @JsonFormat(pattern = "yyyy-MM-dd") // Optional: Specify the format for LocalDate
    @JsonSerialize(using = LocalDateSerializer.class)
    private LocalDate endDate;

}