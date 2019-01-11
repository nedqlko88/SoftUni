package car.dealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "cars")
public class Car extends BaseEntity{
    private String make;
    private String model;
    private Long travelled_distance;
    private Set<Part> parts;
    private Set<Sale> sales;


    @Column
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @Column
    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Column
    public Long getTravelled_distance() {
        return this.travelled_distance;
    }

    public void setTravelled_distance(Long travelled_distance) {
        this.travelled_distance = travelled_distance;
    }

    @ManyToMany(mappedBy = "cars", targetEntity = Part.class)
    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }

    @OneToMany(mappedBy = "carId")
    public Set<Sale> getSales() {
        return this.sales;
    }

    public void setSales(Set<Sale> sales) {
        this.sales = sales;
    }
}
