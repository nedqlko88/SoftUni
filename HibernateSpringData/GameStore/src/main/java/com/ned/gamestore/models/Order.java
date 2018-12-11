package com.ned.gamestore.models;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "orders")
public class Order {
    private Long id;
    private User user;
    private Set<Game> games;

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @ManyToMany
    @JoinTable(name = "orders_games",
            joinColumns = @JoinColumn(name = "order_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id"))
    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
