package car.dealer.dtos.customers;

import car.dealer.dtos.SaleDto;

import java.time.LocalDateTime;
import java.util.Set;

public class CustomerDto {
    private long id;

    private String name;

    private LocalDateTime birthDate;

    private boolean isYoungDriver;

    private Set<SaleDto> sales;




    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(LocalDateTime birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }

    public Set<SaleDto> getSales() {
        return this.sales;
    }

    public void setSales(Set<SaleDto> sales) {
        this.sales = sales;
    }
}
