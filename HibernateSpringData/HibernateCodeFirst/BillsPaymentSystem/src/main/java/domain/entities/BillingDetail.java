package domain.entities;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class BillingDetail extends BaseEntity {
    private String number;
    private User owner;

    public BillingDetail() {
    }

    @Column(name = "number")
    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name = "owner_id", referencedColumnName = "id")
    public User getOwner() {
        return this.owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
