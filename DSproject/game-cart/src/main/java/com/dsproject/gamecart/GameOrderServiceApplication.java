package com.dsproject.gamecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GameOrderServiceApplication {

    //entry point when the application is started
    //SpringApplication.run method is called with the GameOrderServiceApplication class
    //the application will start and be ready to handle requests
    public static void main(String[] args) {
        SpringApplication.run(GameOrderServiceApplication.class, args);
    }

}
