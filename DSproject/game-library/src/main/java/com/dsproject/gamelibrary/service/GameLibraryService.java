package com.dsproject.gamelibrary.service;

import com.dsproject.gamelibrary.dto.StockResponse;
import com.dsproject.gamelibrary.repository.GameLibraryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GameLibraryService {

    private final GameLibraryRepository gameLibraryRepository;

    @Transactional(readOnly = true) // here we are querying the repository after we get a list of game code to find out
    // all the stock objects for the given game code
    // after that we are mapping the stock objects to stock Response objects
    // Finally sending back the list of "stock response" as a Response
    public List<StockResponse> isInStock(List <String> gameCode){
        return gameLibraryRepository.findByGameCodeIn(gameCode).stream()
                .map( stock ->
                        StockResponse.builder()
                                .gameCode(stock.getGameCode())
                                .isInStock(stock.getQuantity()>0 )
                                .build()
                 ).toList();
    }
}
