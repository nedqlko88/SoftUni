package ned.fdmc.data.models;

public class Cat {
    private String name;
    private String breed;
    private String color;
    private Integer numberOfLegs;
    private User creator;


    public Cat(String name, String breed, String color, Integer numberOfLegs, User creator) {
        this.setName(name);
        this.setBreed(breed);
        this.setColor(color);
        this.setNumberOfLegs(numberOfLegs);
        this.setCreator(creator);
    }


    public User getCreator() {
        return this.creator;
    }

    private void setCreator(User creator) {
        this.creator = creator;
    }

    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    public String getColor() {
        return this.color;
    }

    private void setColor(String color) {
        this.color = color;
    }

    public Integer getNumberOfLegs() {
        return this.numberOfLegs;
    }

    private void setNumberOfLegs(Integer numberOfLegs) {
        this.numberOfLegs = numberOfLegs;
    }
}
