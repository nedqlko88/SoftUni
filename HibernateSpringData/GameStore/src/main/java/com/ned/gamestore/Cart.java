package com.ned.gamestore;

import com.ned.gamestore.models.Game;

import java.util.HashMap;

public class Cart {
    private HashMap<String, Game> items;

    public Cart() {
    }

    public void addItem(Game game) {
        if (items == null) {
            this.items = new HashMap<>();
        }
        if (items.containsKey(game.getTitle())) {
            throw new IllegalArgumentException("Game is already in cart!");
        }

        this.items.put(game.getTitle(), game);
    }

    public void removeItem(String title) {
        if (items == null) {
            throw new IllegalArgumentException("Cannot remove from an empty cart!");
        }
        if (!items.containsKey(title)) {
            throw new IllegalArgumentException("Game is not present in cart!");
        }
        this.items.remove(title);

    }
}
