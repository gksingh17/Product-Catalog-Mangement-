package com.dsproject.gamecart.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Games")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Order class, which represents an order placed by a customer in the application
//@Entity annotation indicates that this class is a JPA entity,
//and the @Table annotation specifies the name of the table in the database that should be used to store the entity.
//The orderNumber field is the unique number that identifies the order
//The gameOrderlineItemsList field is a list of GameOrders objects, which represent the games included in the order
//@OneToMany annotation indicates that there is a one-to-many relationship between the Order entity and the GameOrders entity,
//and the cascade attribute specifies that the operations performed on the Order entity should be cascaded to the GameOrders entities.
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id; //PRIMARY KEY
    private String orderNumber;
    @OneToMany(cascade = CascadeType.ALL)
    private List<GameOrders> gameOrderlineItemsList;
}
