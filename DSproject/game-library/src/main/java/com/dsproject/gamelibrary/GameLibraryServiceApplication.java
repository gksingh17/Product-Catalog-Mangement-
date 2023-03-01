package com.dsproject.gamelibrary;

import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import com.dsproject.gamelibrary.model.GameLibrary;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import com.dsproject.gamelibrary.repository.GameLibraryRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableEurekaClient
public class GameLibraryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GameLibraryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(GameLibraryRepository gameLibraryRepository) {
		return args -> {

			GameLibrary gameLibrary1 = new GameLibrary();
			gameLibrary1.setGameCode("God of war");
			gameLibrary1.setGenre("Open World");
			gameLibrary1.setPrice(600);
			gameLibrary1.setQuantity(160);


			GameLibrary gameLibrary2 = new GameLibrary();
			gameLibrary2.setGameCode("uncharted");
			gameLibrary2.setGenre("Puzzle");
			gameLibrary2.setPrice(600);
			gameLibrary2.setQuantity(0);

			gameLibraryRepository.save(gameLibrary1);
			gameLibraryRepository.save(gameLibrary2); // save the two objects in db


		};

	}
}
