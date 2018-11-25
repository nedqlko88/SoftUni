package p03_AnimalFarm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
        Chicken chicken = null;
        DecimalFormat df = new DecimalFormat("#.#####");

        try {
            chicken = new Chicken(name, age);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
            return;
        }


        System.out.println(String.format("Chicken %s (age %d) can produce %s eggs per day.",
                chicken.getName(), chicken.getAge(), df.format(chicken.productPerDay())));

    }
}
