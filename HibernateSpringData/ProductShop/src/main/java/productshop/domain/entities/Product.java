package productshop.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Set;

@Entity(name = "products")
public class Product extends BaseEntity{
   private String name;
   private BigDecimal price;
   private User buyerId;
   private User sellerId;
   private Set<Category> categories;

    @Column(nullable = false)
    @Size(min = 3)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "buyer_id", referencedColumnName = "id")
    public User getBuyerId() {
        return this.buyerId;
    }

    public void setBuyerId(User buyerId) {
        this.buyerId = buyerId;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    public User getSellerId() {
        return this.sellerId;
    }

    public void setSellerId(User sellerId) {
        this.sellerId = sellerId;
    }

    @ManyToMany(targetEntity = Category.class,fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinTable(
            name = "products_categories",
            joinColumns = @JoinColumn(name = "product_id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "category_id", referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
