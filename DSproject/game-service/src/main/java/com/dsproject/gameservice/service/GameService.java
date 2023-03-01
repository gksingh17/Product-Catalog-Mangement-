package com.dsproject.gameservice.service;

import com.dsproject.gameservice.controller.datatransferobject.GameRequest;
import com.dsproject.gameservice.controller.datatransferobject.GameResponse;
import com.dsproject.gameservice.domainmodel.Game;
import com.dsproject.gameservice.repository.GameRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class GameService {

    private final GameRepository gameRepository;

//    public ProductService(ProductRepository productRepository) {
//        this.productRepository = productRepository;
//    }

    //using lombok to add constructor for all classes

    public void createGame(GameRequest gameRequest) {
        Game game = Game.builder()
                .gameName(gameRequest.getGameName())
                .genre(gameRequest.getGenre())
                .price(gameRequest.getPrice())
                .gameDeveloper(gameRequest.getGameDeveloper())
                .build();  //instance of the game to call this implement in product controller

        gameRepository.save(game);
        log.info("Game {} information is added", game.getId());

    }


    public List<GameResponse> getAllGames() {
        List<Game> Games = gameRepository.findAll(); //finds the products in repository, read all the products in database
        //maps the products into a product response class
        return Games.stream().map(this::mapToProductResponse).toList();// map and collect with tolist

    }

    //maps a Game object to a GameResponse object
    //GameResponse object is built using the builder pattern,
    //and the fields are set using the corresponding getters from the Game object
    private GameResponse mapToProductResponse(Game game) {
        return GameResponse.builder()
                .id(game.getId())
                .gameName(game.getGameName())
                .genre(game.getGenre())
                .price(game.getPrice())
                .gameDeveloper(game.getGameDeveloper())
                .build();
    }
}
