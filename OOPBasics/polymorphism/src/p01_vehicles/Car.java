package p01_vehicles;

import java.text.DecimalFormat;

public class Car extends Vehicle {
    private static final double INCREASING_FUELS_CONSUMATION = 0.9;
    public Car(double fuelQuantity, double ltrsPerKm) {
        super(fuelQuantity, ltrsPerKm + INCREASING_FUELS_CONSUMATION);
    }

    @Override
    protected void drive(double distance) {
        double neededLiters = distance * super.getLitersPerKm();
        DecimalFormat df = new DecimalFormat("#.##");
        if (super.getFuelQuantity() >= neededLiters) {
            System.out.printf("%s travelled %s km%n", this.getClass().getSimpleName(), df.format(distance));
            super.setFuelQuantity(super.getFuelQuantity() - neededLiters);
        } else {
            System.out.println(String.format("%s needs refueling", this.getClass().getSimpleName()));
        }
    }

    @Override
    protected void refuel(double liters) {
        double currQuantity = super.getFuelQuantity();
        super.setFuelQuantity(currQuantity + liters);
    }
    @Override
    protected void move() {
        System.out.println("move from Car");
    }
}
