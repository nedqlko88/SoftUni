package VehicleCatalogue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<String, List<Vehicle>> vehicles = new HashMap<>();
        Vehicle vehicle;

        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split(" ");

            vehicle = new Vehicle(tokens[0], tokens[1], tokens[2], Integer.parseInt(tokens[3]));

        vehicles.putIfAbsent(vehicle.getType(), new ArrayList<>());
        
        vehicles.get(vehicle.getType()).add(vehicle);
        
        }

        String line2;
        while (!"Close the Catalogue".equals(line2 = reader.readLine())) {
            for (Map.Entry<String, List<Vehicle>> entry : vehicles.entrySet()) {
                for (Vehicle vehicle1 : entry.getValue()) {
                    if (line2.equals(vehicle1.getModel())) {
                        System.out.println(vehicle1.toString());
                    }
                }
            }
        }

        double carsAverageHP = 0;
        double trucksAverageHP = 0;

        if (vehicles.containsKey("car")) {
            for (Vehicle car : vehicles.get("car")) {
                carsAverageHP += car.getHorsepower();
            }
            carsAverageHP = carsAverageHP / vehicles.get("car").size();
        }

        if (vehicles.containsKey("truck")) {
            for (Vehicle truck : vehicles.get("truck")) {
                trucksAverageHP += truck.getHorsepower();
            }
            trucksAverageHP = trucksAverageHP / vehicles.get("truck").size();
        }

        System.out.println(String.format("Cars have average horsepower of: %.2f.", carsAverageHP));
        System.out.println(String.format("Trucks have average horsepower of: %.2f.", trucksAverageHP));
    }
}
