package com.dsproject.gamecart.service;

import com.dsproject.gamecart.model.GameOrders;
import com.dsproject.gamecart.dto.GameRequest;
import com.dsproject.gamecart.event.GameOrderPlaced;
import com.dsproject.gamecart.model.Order;
import com.dsproject.gamecart.repository.GameRepository;
import com.dsproject.gamecart.dto.StockResponse;
import org.springframework.kafka.core.KafkaTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.dsproject.gamecart.dto.GameOrderLineItemsDto;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.UUID;
import java.util.List;
import java.util.Arrays;

@Service
@Transactional
@RequiredArgsConstructor
public class GameOrderService {

    /*
    Receiving Order Request from client - > to the controller -> Order Request
    to order service -> maps order request to order object -> save in order repository
    */
    private final GameRepository gameRepository;
    // in order to use the WebClient bean we need to inject it in the order service class.
    private final WebClient.Builder webClientBuilder;

    private final KafkaTemplate<String, GameOrderPlaced> GameMessagePipeline;

    public void placeOrder(GameRequest gameRequest) {
        Order order = new Order();
        order.setOrderNumber(UUID.randomUUID().toString()); //random uuid as orderid , map order line items

        List<GameOrders> gameOrderLineItems = gameRequest.getGameOrderLineItemsDtoList()
                .stream()
                .map(this::mapToDto)
                .toList();

        order.setGameOrderlineItemsList(gameOrderLineItems);

        List<String> gameCodes = order.getGameOrderlineItemsList().stream()
                .map(GameOrders::getGameCode)
                .toList();
        // Making a call to game library service and placing an order only if game is in stock.
        // here bodytoMono is a reactive programming
        // here build function will build the URI to include the game code
        StockResponse[] stockResponsesArray = webClientBuilder.build().get()
                .uri("http://game-library/api/game_library",
                        uriBuilder -> uriBuilder.queryParam("gameCode", gameCodes).build())
                .retrieve()
                .bodyToMono(StockResponse[].class)
                .block();

        assert stockResponsesArray != null;
        boolean gameInStock = Arrays.stream(stockResponsesArray)
                .allMatch(StockResponse::isInStock);
        //checks if the game is in stock and performs different actions depending on the availability of the game
        //If the gameInStock variable is true, the gameRepository.save method is called to save the order to the database
        //The kafkaTemplate.send method is then called to send a message to the orderAlertTopic Kafka topic, with the GameOrderPlaced object as the payload
        //If the gameInStock variable is false, an IllegalArgumentException is thrown with an error message indicating that the game is currently unavailable
        if (gameInStock) {
            gameRepository.save(order); //saving orders
            GameMessagePipeline.send("orderAlertTopic", new GameOrderPlaced(order.getOrderNumber()));

        } else {
            throw new IllegalArgumentException("Game is currently unavailable. Please try Again Later");
        }

        //orderRepository.save(order); //saving orders

    }

    //maps a GameOrderLineItemsDto object to a GameOrders object
    // The GameOrders object is created using the default constructor,
    // and its fields are set using the corresponding getters from the GameOrderLineItemsDto object
    // converts a GameOrderLineItemsDto object to a GameOrders object

    private GameOrders mapToDto(GameOrderLineItemsDto gameOrderLineItemsDto) {
        GameOrders gameOrders = new GameOrders();
        gameOrders.setPrice(gameOrderLineItemsDto.getPrice()); //map all the fields
        gameOrders.setQuantity(gameOrderLineItemsDto.getQuantity());
        gameOrders.setGameCode(gameOrderLineItemsDto.getGameCode());
        return gameOrders;


    }
}
