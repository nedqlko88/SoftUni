package bookshop.domain.entities;

import javax.persistence.*;


@Entity(name = "authors")
public class Author extends BaseEntity{

    private String firstName;
    private String lastName;


    @Column
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
