import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class P08CompanyUsers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> companies = new TreeMap<>();
        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] input = line.split(" -> ");
            String name = input[0];
            String id = input[1];

            if (!companies.containsKey(name)) {
                companies.put(name, new LinkedHashSet<>());
            }

            companies.get(name).add(id);

        }

        companies.entrySet().stream()
                .forEach(e -> {
                    System.out.println(e.getKey());

                    e.getValue().stream()
                            .forEach(a -> System.out.println(String.format("-- %s",a)));
                });
    }
}
