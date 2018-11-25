package p01_classBox;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        double length = Double.parseDouble(reader.readLine());
        double width = Double.parseDouble(reader.readLine());
        double height = Double.parseDouble(reader.readLine());

        Box box = null;
        try {
        box = new Box(length, width, height);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

        if (box != null) {
            double volume = box.getVolume();
            double lateral = box.getLateral();
            double surface = box.getSurface();
            System.out.printf("Surface Area - %.2f%n", surface);
            System.out.printf("Lateral Surface Area - %.2f%n", lateral);
            System.out.printf("Volume - %.2f", volume);
        }


    }
}
