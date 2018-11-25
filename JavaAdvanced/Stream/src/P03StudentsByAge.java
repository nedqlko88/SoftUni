import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P03StudentsByAge {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Map<String, Integer> students = new LinkedHashMap<>();

        while (!"END".equals(input = reader.readLine())) {
            String[] studentArray = input.split("\\s+");
            String names = studentArray[0].concat(" ").concat(studentArray[1]);
            int age = Integer.parseInt(studentArray[2]);
            students.putIfAbsent(names, age);
        }

        students.entrySet()
                .stream()
                .filter(a -> a.getValue() >= 18 && a.getValue() <=24)
                .forEach(a -> System.out.printf("%s %d%n", a.getKey(), a.getValue()));

    }
}
