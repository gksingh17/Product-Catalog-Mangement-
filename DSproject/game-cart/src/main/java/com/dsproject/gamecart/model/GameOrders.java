package com.dsproject.gamecart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "game_order_list")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class GameOrders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //AUTO INCREMENTED
    private Long id; //PRIMARY KEY
    private String gameCode;
    private BigDecimal price;
    private Integer quantity;
}
