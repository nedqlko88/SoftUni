package car.dealer.entities;

import javax.persistence.*;

@Entity
@Table(name = "sales")
public class Sale extends BaseEntity {
    private Double discount;
    private Car carId;
    private Customer customerId;

    @Column
    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @ManyToOne(targetEntity = Car.class)
    @JoinColumn(name = "car_id", referencedColumnName = "id")
    public Car getCarId() {
        return this.carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn( name = "customer_id", referencedColumnName = "id")
    public Customer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
