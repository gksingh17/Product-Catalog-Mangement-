package com.dsproject.gamelibrary.controller;

import com.dsproject.gamelibrary.dto.StockResponse;
import com.dsproject.gamelibrary.service.GameLibraryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game_library")
@RequiredArgsConstructor
public class GameLibraryController {

    private final GameLibraryService gameLibraryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StockResponse> isInStock(@RequestParam List<String> gameCode) {
        return gameLibraryService.isInStock(gameCode);
    }
}

