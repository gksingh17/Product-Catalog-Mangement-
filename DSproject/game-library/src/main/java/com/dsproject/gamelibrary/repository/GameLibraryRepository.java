package com.dsproject.gamelibrary.repository;

import com.dsproject.gamelibrary.model.GameLibrary;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GameLibraryRepository extends JpaRepository<GameLibrary, Long> {


  // this method will take in a list of game code as input and  Spring data JPA will return a list of inventory objects that
    // match the game code.
    List<GameLibrary> findByGameCodeIn(List<String> gameCode);
}
