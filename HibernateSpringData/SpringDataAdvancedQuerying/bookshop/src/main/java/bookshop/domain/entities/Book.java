package bookshop.domain.entities;

import bookshop.domain.enums.AgeRestriction;
import bookshop.domain.enums.EditionType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Set;

@Entity(name = "books")
public class Book extends BaseEntity{

    private String title;
    private String description;
    private EditionType editionType;
    private BigDecimal price;
    private int copies;
    private LocalDate releaseDate;
    private AgeRestriction ageRestriction;
    private Author author;
    private Set<Category> categories;


    @Column(nullable = false)
    @Length(min = 1, max = 50)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(columnDefinition = "text",length = 1000)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Enumerated
    @Column(nullable = false)
    public EditionType getEditionType() {
        return this.editionType;
    }

    public void setEditionType(EditionType editionType) {
        this.editionType = editionType;
    }

    @Column(nullable = false)
    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Column(nullable = false)
    public int getCopies() {
        return this.copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    @Column
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Enumerated
    @Column(nullable = false)
    public AgeRestriction getAgeRestriction() {
        return this.ageRestriction;
    }

    public void setAgeRestriction(AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    // unidirectional ManyToOne
    @ManyToOne(targetEntity = Author.class)
    @JoinColumn(name = "author_id",referencedColumnName = "id")
    public Author getAuthor() {
        return this.author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @ManyToMany(targetEntity = Category.class)
    @JoinTable(
            name = "books_categories",joinColumns = @JoinColumn(name = "book_id",referencedColumnName = "id"),
    inverseJoinColumns =  @JoinColumn(name = "category_id",referencedColumnName = "id"))
    public Set<Category> getCategories() {
        return this.categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }
}
