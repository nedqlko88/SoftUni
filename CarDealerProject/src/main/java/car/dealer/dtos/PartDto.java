package car.dealer.dtos;

import car.dealer.entities.BaseEntity;
import car.dealer.entities.Car;
import car.dealer.entities.Supplier;

import javax.persistence.*;
import java.util.Set;

public class PartDto extends BaseEntity {
    private String name;
    private Double price;
    private Long quantity;



    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Double getPrice() {
        return this.price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }


    public Long getQuantity() {
        return this.quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

}
