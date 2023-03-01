package com.dsproject.gamecart.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class GameConfig {

    //returns a WebClient.Builder object that can be used to create a WebClient
    //WebClient is a non-blocking, reactive HTTP client with efficient connection pooling and request management
    //WebClient.Builder provides a convenient way to create a WebClient with a default configuration,
    //and allows you to customize the WebClient with additional options before using it to make HTTP requests
    //WebClient is used to perform HTTP requests asynchronously and process the responses in a reactive manner.
    @Bean
    @LoadBalanced
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

}