package com.dsproject.gamecart.dto;


import lombok.Data;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
//StockResponse class, which represents the availability of a game in the game library
//gameCode field is the unique code that identifies the game
//this class provides a simple representation of the availability of a game in the game library,
//and can be used to convey this information to clients through the API.
public class StockResponse {
    private String gameCode;
    private boolean isInStock;
}
