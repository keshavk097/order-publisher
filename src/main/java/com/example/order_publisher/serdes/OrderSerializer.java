package com.example.order_publisher.serdes;

import com.example.order_publisher.model.StandingOrder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

public class OrderSerializer implements Serializer<StandingOrder> {
    @Override
    public byte[] serialize(String topic, StandingOrder data) {
        try {
            return new ObjectMapper().writeValueAsBytes(data);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
