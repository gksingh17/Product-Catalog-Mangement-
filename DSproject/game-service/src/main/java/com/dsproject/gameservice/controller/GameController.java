package com.dsproject.gameservice.controller;

import com.dsproject.gameservice.controller.datatransferobject.GameRequest;
import com.dsproject.gameservice.controller.datatransferobject.GameResponse;
import com.dsproject.gameservice.service.GameService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
@RequiredArgsConstructor // for product service

public class GameController {

    private final GameService gameService;

    //HTTP POST requests to the /games endpoint
    //@PostMapping annotation specifies that this method should be called for HTTP POST requests with the /games URI
    //@ResponseStatus annotation specifies that the HTTP status code of the response should be CREATED (HTTP status code 201) when this method is called
    //@RequestBody annotation indicates that the request body should be bound to a GameRequest object, which is passed as an argument to the gameService.createGame method
    //gameService.createGame method is called to create a new game using the information provided in the request body
    //This method allows clients to create a new game by sending a POST request with the game information in the request body

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody GameRequest gameRequest) {
        gameService.createGame(gameRequest);
        //endpoint to create a game

    }

    //method handles HTTP GET requests to the /games endpoint
    //@GetMapping annotation specifies that this method should be called for HTTP GET requests with the /games URI
    //@ResponseStatus annotation specifies that the HTTP status code of the response should be OK (HTTP status code 200) when this method is called
    //gameService.getAllGames method is called to retrieve a list of all available games, and the response
    //body is a list of GameResponse objects representing the games
    //This method allows clients to retrieve a list of all available games

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<GameResponse> getAllGames() {
        return gameService.getAllGames();


    }

}
