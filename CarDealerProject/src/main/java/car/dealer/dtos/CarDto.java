package car.dealer.dtos;

public class CarDto {
    private String make;
    private String model;
    private Long travelled_distance;


    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }


    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    public Long getTravelled_distance() {
        return this.travelled_distance;
    }

    public void setTravelled_distance(Long travelled_distance) {
        this.travelled_distance = travelled_distance;
    }

}
