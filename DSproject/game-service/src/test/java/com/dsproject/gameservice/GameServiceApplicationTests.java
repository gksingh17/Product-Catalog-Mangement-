package com.dsproject.gameservice;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import com.dsproject.gameservice.controller.datatransferobject.GameRequest;
import com.dsproject.gameservice.repository.GameRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class GameServiceApplicationTests {
    @Container //manually specify , provide docker image name
    static MongoDBContainer mongoDBContainer = new MongoDBContainer("mongo:4.4.2"); //statically access the uri
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper; //json conversion
    @Autowired
    private GameRepository gameRepository;

    @DynamicPropertySource //adds property dynamically when tests is ran
    static void setProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
        dynamicPropertyRegistry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
        //test starts mongodb container by downloading docker image, gets the replicaseturl and adds to spring data mongo db uri
    }

    //this is a test method that tests the creation of a new game
    //@Test annotation indicates that this is a test method that should be run as part of the test suite
    //gameRequest variable is initialized with a GameRequest object containing the information for the game to be created
    //objectMapper.writeValueAsString method is used to serialize the gameRequest object to a JSON string, which will be used as the request body in the API call
    //mockMvc.perform method is used to perform an HTTP POST request to the /api/product endpoint with the productRequestString as the request body
    //andExpect method is used to specify the expected HTTP status code of the response, which should be CREATED (HTTP status code 201)
    //assertEquals method is used to verify that the number of games in the repository is equal to 1, which indicates that a new game has been created successfully.
    //this test was created in the inital phases of the project development, due to changes in implemtation of code it may not work in the final phase.

    @Test
    void shouldCreateProduct() throws Exception {
        GameRequest gameRequest = getProductRequest();
        String productRequestString = objectMapper.writeValueAsString(gameRequest);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/product")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(productRequestString))
                .andExpect(status().isCreated());
        Assertions.assertEquals(1, gameRepository.findAll().size());


    }

    private GameRequest getProductRequest() {
        return GameRequest.builder()
                .gameName("god of war")
                .genre("god of war")
                .gameDeveloper("Santa Monica Studio")
                .price(BigDecimal.valueOf(600))
                .build();
    }

}
