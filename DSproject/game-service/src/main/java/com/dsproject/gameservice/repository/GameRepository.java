package com.dsproject.gameservice.repository;

import com.dsproject.gameservice.domainmodel.Game;
import org.springframework.data.mongodb.repository.MongoRepository;

// interface extends the MongoRepository interface, which provides basic CRUD operations for a MongoDB repository
public interface GameRepository extends MongoRepository<Game, String> {
}
