package p03_ferrari;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String driversNames = reader.readLine();
        Car ferrari = new Ferrari(driversNames);
        System.out.println(String.format("%s/%s/%s/%s", ferrari.MODEL,
                ferrari.useBrakes(), ferrari.pushTheGazPedal(), ferrari.getName()));

    }
}
