package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.*;
import java.math.BigDecimal;


public class ProductDto {
    @Expose
    private String name;

    @Expose
    private BigDecimal price;

    @NotNull(message = "Name cannot be null.")
    @Size(min = 3, message = "The name must be at least 3 characters.")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull(message = "The price cannot be null.")
//    @Positive(message = "Price must be positive number.")
    @DecimalMin(value = "0.01", message = "The price must be greater than 0.1")
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
