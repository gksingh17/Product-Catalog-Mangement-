package com.dsproject.gamecart.event;


import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GameOrderPlaced {

    private String orderNumber;
}
