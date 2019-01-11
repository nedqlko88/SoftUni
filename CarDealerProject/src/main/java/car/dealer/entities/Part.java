package car.dealer.entities;

import com.fasterxml.jackson.databind.ser.Serializers;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "parts")
public class Part extends BaseEntity {
    private String name;
    private Double price;
    private Long quantity;
    private Supplier supplier;
    private Set<Car> cars;

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column
    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Column
    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    @ManyToOne
    @JoinColumn(referencedColumnName = "id", name = "supplier_id")
    public Supplier getSupplier() {
        return this.supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    @ManyToMany(targetEntity = Car.class)
    @JoinTable(name = "parts_cars",
            joinColumns = @JoinColumn(name = "part_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "car_id", referencedColumnName = "id")
    )
    public Set<Car> getCars() {
        return this.cars;
    }

    public void setCars(Set<Car> cars) {
        this.cars = cars;
    }
}
