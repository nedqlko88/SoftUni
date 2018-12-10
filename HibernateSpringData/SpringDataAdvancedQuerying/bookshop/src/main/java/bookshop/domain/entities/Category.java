package bookshop.domain.entities;

import javax.persistence.*;

@Entity(name = "categories")
public class Category extends BaseEntity {

    private String name;

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
