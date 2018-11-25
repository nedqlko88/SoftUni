import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P01StudentsByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        Map<String, Integer> students = new LinkedHashMap<>();
        while (!"END".equals(input = reader.readLine())) {
            String[] studArray = input.split("\\s+");
            String name = studArray[0] + " " + studArray[1];
            int group = Integer.parseInt(studArray[2]);

            if (!students.containsKey(name)) {
                students.put(name, group);
            }
        }

        students.entrySet()
                .stream()
                .filter(a -> a.getValue() == 2)
                .sorted((a,b) -> {
                    String firstName1 = a.getKey().split(" ")[0];
                    String firstName2 = b.getKey().split(" ")[0];
                    return firstName1.compareTo(firstName2);
                })
                .forEach(a -> System.out.println(a.getKey()));

    }
}
