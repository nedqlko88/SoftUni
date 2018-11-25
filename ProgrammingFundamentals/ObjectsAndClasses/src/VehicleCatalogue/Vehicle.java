package VehicleCatalogue;

public class Vehicle {
    private static final String TYPE_CAR = "Car";
    private static final String TYPE_TRUCK = "Truck";

    private String type;
    private String model;
    private String color;
    private int horsepower;


    public Vehicle(String type, String model, String color, int horsepower) {
        this.type = type;
        this.model = model;
        this.color = color;
        this.horsepower = horsepower;
    }

    public String getType() {
        return this.type;
    }

    public String getModel() {
        return this.model;
    }

    public String getColor() {
        return this.color;
    }

    public int getHorsepower() {
        return this.horsepower;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Type: ").append(String.valueOf(this.type.charAt(0)).toUpperCase()).append(this.type.substring(1)).append(System.lineSeparator())
                .append("Model: ").append(this.model).append(System.lineSeparator())
                .append("Color: ").append(this.color).append(System.lineSeparator())
                .append("Horsepower: ").append(this.horsepower);
        return sb.toString();
    }
}
