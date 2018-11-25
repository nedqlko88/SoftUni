package p01_vehicles;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputCar = reader.readLine().split("\\s+");
        String[] inputTruck = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());
        Vehicle car = new Car(Double.parseDouble(inputCar[1]), Double.parseDouble(inputCar[2]));
        Vehicle truck= new Truck(Double.parseDouble(inputTruck[1]), Double.parseDouble(inputTruck[2]));

        while (n-- > 0) {
            String[] commands = reader.readLine().split("\\s+");
            String command = commands[0];
            String vehicleType = commands[1];
            double quantity =Double.parseDouble(commands[2]);

            if ("Drive".equals(command)) {
                if ("Car".equals(vehicleType)) {
                    car.drive(quantity);
                } else {
                    truck.drive(quantity);
                }
            } else {
                if ("Car".equals(vehicleType)) {
                    car.refuel(quantity);
                } else {
                    truck.refuel(quantity);
                }
            }
        }

        System.out.println(car.toString());
        System.out.println(truck.toString());

    }
}
