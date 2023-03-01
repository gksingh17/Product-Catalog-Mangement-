package com.dsproject.gamecart.repository;

import com.dsproject.gamecart.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

//interface extends the JpaRepository interface, which provides basic CRUD operations for a JPA repository
public interface GameRepository extends JpaRepository<Order, Long> {

}
