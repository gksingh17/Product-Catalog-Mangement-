package com.dsproject.gameservice.controller.datatransferobject;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class GameRequest {
    private String gameName;
    private String genre; //description
    private String gameDeveloper;
    private BigDecimal price;

}
