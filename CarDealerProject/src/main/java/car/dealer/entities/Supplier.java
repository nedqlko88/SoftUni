package car.dealer.entities;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "suppliers")
public class Supplier extends BaseEntity {
    private String name;
    private boolean isImporter;
    private Set<Part> parts;

    @Column
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "is_importer")
    public boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    @OneToMany(mappedBy = "supplier")
    public Set<Part> getParts() {
        return this.parts;
    }

    public void setParts(Set<Part> parts) {
        this.parts = parts;
    }
}

