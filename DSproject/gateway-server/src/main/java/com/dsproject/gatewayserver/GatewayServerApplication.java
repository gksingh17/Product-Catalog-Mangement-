package com.dsproject.gatewayserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
// It is used to access different ports
public class GatewayServerApplication {
    public static void main(String[] args) {

        // It act as an entry point for the different services and it will redirect to the destination page by configuring the gateway of it.

        SpringApplication.run(GatewayServerApplication.class,args);
    }
}
