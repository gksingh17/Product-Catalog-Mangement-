# Distributed System Project

## Steps to run the Project 
Initially to run our project you need to have different applications installed on your computer system like:-
- Docker
- Postman
- SQL 
  - Windows
    - ```MySQL WorkBench```
  - Mac
    - Run command ```brew install mysql```
- Intellij/VS Code


- After installing the above applications you need to start the docker to run the zookeeper and kafka and the syntax to start the docker is

    ``` docker compose up -d ```


- The first file which need to run after the docker is the Server location application file
- The next files which will need to run followed by the Server location application file are the game service and order-alert-service.
- Then obtain the port number of the game service application through which it is been executed and also the port number will not be same every time it will be different and through that port number check the uri in the postman application for eg: 
  ``` http://localhost:{game-service_port_number}/api/game ```

- In <b>postman</b> application send a POST request in the json format with the following details:
  
  ```
  {
   "gameName":"God of war",
   "genre": "Open World",
   "gameDeveloper": "santa monica labs",
   "price": 600
  }
   ```

- Now after sending a GET request, you also need to get post request in the postman application so kindly run the http://localhost:
  {game-service_port_number}/api/game to get the response. Kindly note that port number in your system will be different.

- The next file which needs to run now is Game order service application and for that in the postman application again you need to post a request in the json format and the uri is 
 ``` http://localhost: {game-order-service_port_number}/api/game_order ``` 
  and by checking so order will get placed. Kindly note that the port number again will be different for the service and the details in the json format which need to be post are:

  ```
    {
      "gameOrderLineItemsDtoList":
        [
          {
            "gameCode":"God of war",
            "price": 100,
            "quantity": 25
          }
        ]
   }
  ```
- After placing the order check the terminal of OrderAlertService where it will give an alert regarding the which game order has been placed with its order ID.
- To check for the out-of-stock product kindly pass the following details in the json format and its status will be printed in the console that it is currently unavailable
  ```
  {
    "gameOrderLineItemsDtoList":
     [
       {
         "gameCode":"God of war",
         "price": 100,
         "quantity": 25
       },
       
       {
         "gameCode":"uncharted",
         "price": 10,
         "quantity": 25
       }
     ]
  }
  ```
- To check game library service, add another game detail in the service and send a post request again.
- If the game is available, the post request will be sent, and order alert service will give a prompt saying "order placed" else it will throw an error
- For the gateway server you need to run ```https://localhost:8761``` in your browser which will inform you about which all services are running.


- To check the data in database (For MAC)
- Login using command:

  ``` mysql -u root -p  ```

- Select Database using command:

  ```use game-library;```

- Get Table using command:

  ```show table;```

- Get information from table run command:
  
  ```SELECT * FROM game_library```

