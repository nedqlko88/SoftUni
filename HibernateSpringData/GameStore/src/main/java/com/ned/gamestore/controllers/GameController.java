package com.ned.gamestore.controllers;

import com.ned.gamestore.models.Game;
import com.ned.gamestore.services.interfaces.GameService;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import java.math.BigDecimal;
import java.util.Date;

@Controller
public class GameController {
    private final GameService gameService;

    public GameController(GameService gameService) {
        this.gameService = gameService;
    }

    public String add(String title, BigDecimal price, BigDecimal size,
                      String trailer, String thumbnailUrl, String description,
                      Date releaseDate) {
        Game game = new Game();
        game.setTitle(title);
        game.setPrice(price);
        game.setSize(size);
        game.setTrailer(trailer);
        game.setThumbnailUrl(thumbnailUrl);
        game.setDescription(description);
        try {
            this.gameService.addGame(game);
        } catch (Exception e) {
            return e.getMessage();
        }
        return "Game added successfully";
    }
}
