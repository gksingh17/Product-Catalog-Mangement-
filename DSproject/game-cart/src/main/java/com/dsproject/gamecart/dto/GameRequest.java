package com.dsproject.gamecart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
//gameOrderLineItemsDtoList field is a list of GameOrderLineItemsDto objects,
//each of which represents an individual game and its corresponding quantity in the order.
public class GameRequest {
    private List<GameOrderLineItemsDto> gameOrderLineItemsDtoList;
}
