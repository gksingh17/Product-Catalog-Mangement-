package com.dsproject.orderalertservice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
// To provide log information
@Slf4j
public class OrderAlertServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderAlertServiceApplication.class, args);
    }

    @KafkaListener(topics = "orderAlertTopic")
    public void handleAlert(OrderPlacedEvent orderPlacedEvent) {
        // send out email notification??
        log.info("Received Notification for Order - {}", orderPlacedEvent.getOrderNumber());


    }

}
