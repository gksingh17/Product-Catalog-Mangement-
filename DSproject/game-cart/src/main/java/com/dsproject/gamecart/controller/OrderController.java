package com.dsproject.gamecart.controller;

import lombok.RequiredArgsConstructor;
import com.dsproject.gamecart.dto.GameRequest;
import com.dsproject.gamecart.service.GameOrderService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/game_order")
@RequiredArgsConstructor
public class OrderController {

    //for calling order service
    private final GameOrderService gameOrderService;

    //method handles HTTP POST requests to the /placeorder endpoint
    //@ResponseStatus annotation specifies that the HTTP status code of the
    //response should be CREATED (HTTP status code 201) when this method is called.
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String placeOrder(@RequestBody GameRequest gameRequest) {
        gameOrderService.placeOrder(gameRequest);
        return "Game Purchased, Thank You";
    }
}
