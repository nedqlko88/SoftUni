import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p08AnonymousThreat {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.stream(reader.readLine().split("\\s+")).collect(Collectors.toList());
        String line;

        List<String> result = new ArrayList<>();

        while (!"3:1".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            String command = commands[0];
            int index = Integer.parseInt(commands[1]);
            int part = Integer.parseInt(commands[2]);

            switch (command) {
                case "merge":
                    mergeElements(input, index, part);
                    break;
                case "divide":
                    divideElement(input, index, part);
                    break;
            }

        }
        System.out.println(String.join(" ", input));

    }

    private static void divideElement(List<String> input, int index, int part) {
        String element = input.get(index);
        List<String> dividedElement = new ArrayList<>();
        int lenght = element.length() / part;


        if (element.length() % part == 1) {
            for (int i = 0; i < element.length() - 1; i += lenght) {
                dividedElement.add(element.substring(i, i + lenght));
            }
            dividedElement.set(part - 1, dividedElement.get(part - 1) + element.charAt(element.length() - 1));
//            System.out.println(String.join(" ", dividedElement));
        } else if (element.length() % part == 2) {
            for (int i = 0; i < element.length() - 2; i += lenght) {
                dividedElement.add(element.substring(i, i + lenght));
            }
            dividedElement.set(part - 1, dividedElement.get(part - 1) + element.charAt(element.length() -2) + element.charAt(element.length() -1));

        } else {
            for (int i = 0; i < element.length(); i+= lenght) {
                dividedElement.add(element.substring(i, i + lenght));
            }
        }
        input.remove(index);
        input.addAll(index, dividedElement);

    }

    private static void mergeElements(List<String> input, int index, int part) {
        if (index < 0) {
            index = 0;
        }
        if (part >= input.size()) {
            part = input.size() - 1;
        }
        int count = part - index - 1;

        while (count >= 0) {
            String concElement = input.get(index) + input.get(index + 1);
            input.set(index, concElement);
            input.remove(index + 1);
            count--;
        }
    }
}
