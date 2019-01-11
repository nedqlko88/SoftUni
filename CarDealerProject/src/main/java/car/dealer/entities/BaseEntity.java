package car.dealer.entities;

import javax.persistence.*;

@MappedSuperclass
public abstract class BaseEntity {
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
