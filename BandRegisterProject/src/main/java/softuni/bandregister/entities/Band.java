package softuni.bandregister.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;


@Entity
@Table(name = "bands")
public class Band {
    private Integer id;
    private String name;
    private String members;
    private Double honorarium;
    private String genre;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(nullable = false)
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(nullable = false)
    public String getMembers() {
        return this.members;
    }

    public void setMembers(String members) {
        this.members = members;
    }

    @Column(nullable = false)
    public Double getHonorarium() {
        return this.honorarium;
    }

    public void setHonorarium(Double honorarium) {
        this.honorarium = honorarium;
    }

    @Column(nullable = false)
    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}
