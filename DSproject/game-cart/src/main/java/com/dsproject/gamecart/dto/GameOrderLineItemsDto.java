package com.dsproject.gamecart.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
//GameOrderLineItemsDto class, which represents a game included in an order
//class is used to transfer data related to a game included in an order,
//and can be used to create an instance of the GameOrders entity
public class GameOrderLineItemsDto {
    private Long id;
    private String gameCode; //unique code
    private BigDecimal price;
    private Integer quantity;
}
