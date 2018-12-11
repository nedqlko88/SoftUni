package com.ned.gamestore.models;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "games")
public class Game {
    private Long id;
    private String title;
    private BigDecimal price;
    private BigDecimal size;
    private String trailer;
    private String thumbnailUrl;
    private String description;
    private Set<Order> orders;
//    private Set<User> users;

    public Game() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column
    @Size(min = 3, max = 100)
    @Pattern(regexp = "\\b[A-Z][a-z]{2,100}")
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column
    @Digits(integer = 5, fraction = 2)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Price must be a positive number!");
        }
        this.price = price;
    }

    @Column
    @Digits(integer = 5, fraction = 1)
    public BigDecimal getSize() {
        return this.size;
    }

    public void setSize(BigDecimal size) {
        if (size.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Size must be a positive number!");
        }
        this.size = size;
    }

    @Column
    @Size(min = 11, max = 11)
    public String getTrailer() {
        return this.trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    @Column
    @Pattern(regexp = "^(http|https|ftp)://.*$", message = "URL must starts with http or https")
    public String getThumbnailUrl() {
        return this.thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @Column
    @Size(min = 20)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @ManyToMany(mappedBy = "games")
    public Set<Order> getOrders() {
        return this.orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

//    @ManyToMany
//    @JoinTable(name = "games_users",
//            joinColumns = @JoinColumn(name = "game_id",referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id")
//    )
//    public Set<User> getUsers() {
//        return this.users;
//    }
//
//    public void setUsers(Set<User> users) {
//        this.users = users;
//    }
}
