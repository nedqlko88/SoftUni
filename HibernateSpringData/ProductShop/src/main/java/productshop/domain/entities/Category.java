package productshop.domain.entities;


import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity(name = "categories")
public class Category extends BaseEntity{
    private String name;
    private Set<Product> products;

    @Column(nullable = false)
    @Size(min = 3, max = 15)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(targetEntity = Product.class, mappedBy = "categories",fetch = FetchType.EAGER)
    public Set<Product> getProducts() {
        return this.products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
