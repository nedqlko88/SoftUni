package com.ned.gamestore.controllers;

import com.ned.gamestore.Cart;
import com.ned.gamestore.models.Game;
import com.ned.gamestore.services.interfaces.GameService;
import com.ned.gamestore.services.interfaces.OrderService;
import org.springframework.stereotype.Controller;

@Controller
public class OrderController {
    private final OrderService orderService;
    private final GameService gameService;
    private Cart cart;


    public OrderController(OrderService orderService, GameService gameService) {
        this.orderService = orderService;
        this.gameService = gameService;
    }
    public String add(String title) {
        if (cart == null) {
            this.cart = new Cart();
        }
        if (!this.gameService.checkIfGameExists(title)) {
            return "Game doesn't exist!";
        }

        Game game = this.gameService.findGameByTitle(title);
        this.cart.addItem(game);

        return "Game added successfully!";
    }

}
