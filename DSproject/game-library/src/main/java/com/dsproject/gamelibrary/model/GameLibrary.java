package com.dsproject.gamelibrary.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "game_library")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GameLibrary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String gameCode; //product representation
    private Integer quantity;
    private String genre;
    private Integer price;

}
