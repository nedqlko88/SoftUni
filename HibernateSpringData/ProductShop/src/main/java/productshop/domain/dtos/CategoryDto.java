package productshop.domain.dtos;

import com.google.gson.annotations.Expose;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CategoryDto {
    @Expose
    private String name;

    @NotNull(message = "Name can't be null.")
    @Size(min = 3, max = 15,message = "The length of the name of the category must be between 3 and 15 characters.")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
