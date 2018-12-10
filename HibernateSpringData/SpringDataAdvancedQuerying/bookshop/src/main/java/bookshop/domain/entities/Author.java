package bookshop.domain.entities;

import javax.persistence.*;
import java.util.Set;


@Entity(name = "authors")
public class Author extends BaseEntity{

    private String firstName;
    private String lastName;
    private Set<Book> books;

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

    @OneToMany(mappedBy = "author", targetEntity = Book.class,fetch = FetchType.EAGER)
    public Set<Book> getBooks() {
        return this.books;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }
}
