package com.dsproject.gameservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class GameServiceApplication {

    //the entry point when the application is started
    //SpringApplication.run method is called with the GameServiceApplication class
    ////the application will start and be ready to handle requests
    public static void main(String[] args) {
        SpringApplication.run(GameServiceApplication.class, args);
    }

}
