package com.dsproject.gameservice.domainmodel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document(value = "game")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
//@Document annotation indicates that this class is a MongoDB document,
//and the value attribute specifies the name of the collection in which the documents of this type should be stored
//@Builder annotation generates a builder for the class,
// which allows to create instances of the class using a builder pattern
//@Data annotation generates various methods for the class, such as getters, setters, equals, and hashCode
// other fields are the game name, genre, game developer, and price,
// which represent the basic information about the game

public class Game {
    @Id
    private String id;
    private String gameName;
    private String genre; //description
    private String gameDeveloper;
    private BigDecimal price;


}
