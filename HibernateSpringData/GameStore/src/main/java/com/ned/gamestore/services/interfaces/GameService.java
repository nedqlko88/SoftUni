package com.ned.gamestore.services.interfaces;


import com.ned.gamestore.models.Game;

public interface GameService {
    void addGame(Game game);

    boolean checkIfGameExists(String title);

    Game findGameByTitle(String title);

}
