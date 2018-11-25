package p01_vehicles;

import java.text.DecimalFormat;

public class Truck extends Vehicle {
    private static final double INCREASING_FUEL_CONSUPTION = 1.6;

    public Truck(double fuelQuantity, double ltrsPerKm) {
        super(fuelQuantity, ltrsPerKm + INCREASING_FUEL_CONSUPTION);
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
        double realRefueling = liters * 0.95;
        double currQuantity = super.getFuelQuantity();
        super.setFuelQuantity(currQuantity + realRefueling);
    }


    @Override
    protected void move() {
        System.out.println("move from Truck");
    }
}
