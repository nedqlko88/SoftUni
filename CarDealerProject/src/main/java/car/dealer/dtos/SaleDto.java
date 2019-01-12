package car.dealer.dtos;

import car.dealer.entities.BaseEntity;
import car.dealer.entities.Car;
import car.dealer.entities.Customer;

public class SaleDto extends BaseEntity {
    private Double discount;
    private Car carId;
    private Customer customerId;

    public Double getDiscount() {
        return this.discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    public Car getCarId() {
        return this.carId;
    }

    public void setCarId(Car carId) {
        this.carId = carId;
    }

    public Customer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Customer customerId) {
        this.customerId = customerId;
    }
}
