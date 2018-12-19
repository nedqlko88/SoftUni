package productshop.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "users")
public class User extends BaseEntity{
   private String firstName;
   private String lastName;
   private int age;
   private Set<Product> productsSold;
   private Set<Product> productsBought;
   private Set<User> friends;


    @Column
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(nullable = false)
    @Size(min = 3)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column
    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @OneToMany(mappedBy = "sellerId")
    public Set<Product> getProductsSold() {
        return this.productsSold;
    }

    public void setProductsSold(Set<Product> productsSold) {
        this.productsSold = productsSold;
    }

    @OneToMany(mappedBy = "buyerId")
    public Set<Product> getProductsBought() {
        return this.productsBought;
    }

    public void setProductsBought(Set<Product> productsBought) {
        this.productsBought = productsBought;
    }

    @ManyToMany(targetEntity = User.class)
    @JoinTable(name = "users_friends",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "friend_id", referencedColumnName = "id"))
    public Set<User> getFriends() {
        return this.friends;
    }

    public void setFriends(Set<User> friends) {
        this.friends = friends;
    }
}




