package com.ned.gamestore.models;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "users")
public class User {
    private Long id;
    private String email;
    private String password;
    private String fullName;
    private Set<Order> orders;
    private Set<Game> games;
    private boolean isAdmin;

    public User() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(unique = true)
    @Pattern(regexp = "[^-_]([a-zA-Z0-9_.-]+[^-_])@([a-zA-Z0-9]*\\.[a-zA-Z0-9]+)+$", message = "Email not valid!")
    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    @Size(min = 6)
    @Pattern(regexp = "((?=.*[a-z]).*(?=.*[A-Z]).*(?=.*[0-9]).*)", message = "Password not valid!")
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @OneToMany(mappedBy = "user")
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @ManyToMany
    public Set<Game> getGames() {
        return this.games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }

    @Column
    public boolean isAdmin() {
        return this.isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
