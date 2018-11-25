package p01_vehicles;

import java.text.DecimalFormat;
import java.util.regex.Matcher;

public abstract class Vehicle{
    private double fuelQuantity;
    private double litersPerKm;

    public Vehicle(double fuelQuantity, double ltrsPerKm) {
        this.setFuelQuantity(fuelQuantity);
        this.setLitersPerKm(ltrsPerKm);
    }

    public double getFuelQuantity() {
        return this.fuelQuantity;
    }

    void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }

    public double getLitersPerKm() {
        return this.litersPerKm;
    }

    void setLitersPerKm(double litersPerKm) {
        this.litersPerKm = litersPerKm;
    }

    protected abstract void drive(double distance);
    protected abstract void refuel(double liters);

    protected void move() {
        System.out.println("move");
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.00");
        double quantity = Math.round(this.getFuelQuantity() * 100.0) / 100.0;
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s: ", this.getClass().getSimpleName()))
                .append(df.format(quantity));
        return sb.toString();
    }
}
