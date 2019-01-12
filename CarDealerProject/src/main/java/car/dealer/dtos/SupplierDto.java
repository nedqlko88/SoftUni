package car.dealer.dtos;

public class SupplierDto {
    private Long id;
    private String name;
    private boolean isImporter;
    private int numberOfParts;


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public boolean isImporter() {
        return this.isImporter;
    }

    public void setImporter(boolean importer) {
        isImporter = importer;
    }

    public int getNumberOfParts() {
        return this.numberOfParts;
    }

    public void setNumberOfParts(int numberOfParts) {
        this.numberOfParts = numberOfParts;
    }
}

