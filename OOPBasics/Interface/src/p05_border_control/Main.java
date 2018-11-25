package p05_border_control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine;
        List<Identifable> imigrants = new ArrayList<>();

        while (!"End".equals(inputLine = reader.readLine())) {
            String[] commands = inputLine.split("\\s+");
            Identifable imigrant = null;
            if (commands.length == 2) {
                imigrant = new Robot(commands[0], commands[1]);
            } else if (commands.length == 3) {
                imigrant = new Citizen(commands[0],Integer.parseInt(commands[1]), commands[2]);
            }

            imigrants.add(imigrant);
        }
        String lastDigits = reader.readLine();

        imigrants.stream()
                .filter(i -> i.getId().endsWith(lastDigits))
                .forEach(i -> System.out.println(i.getId()));
    }
}
