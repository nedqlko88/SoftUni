import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P09SoftUniExamResults {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<String> banned = new ArrayList<>();
//        Map<String, Map<String, Integer>> students = new HashMap<>();
        Map<String, Integer> submissions = new HashMap<>();
        Map<String, Integer> results = new HashMap<>();


        while (!"exam finished".equals(line = reader.readLine())) {
            String[] tokens = line.split("-");
            String name = tokens[0];

            if (tokens.length == 2) {
// TODO: 30-Oct-18
                banned.add(name);
            } else {
                String language = tokens[1];
                int points = Integer.parseInt(tokens[2]);

//                students.putIfAbsent(language, new HashMap<>());
//                students.get(language).put(name, points);
                results.putIfAbsent(name, points);

                if (results.get(name) < points) {
                results.put(name, points);
                }

                submissions.putIfAbsent(language, 0);
                submissions.put(language, submissions.get(language) + 1);


            }


        }
        System.out.println("Results:");
        results.entrySet().stream()
                .sorted((s1,s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                .filter(e -> !banned.contains(e.getKey()))
                .forEach(e -> System.out.println(String.format("%s | %d", e.getKey(), e.getValue())));


        System.out.println("Submissions:");
          submissions.entrySet().stream()
                  .sorted((s1,s2) -> Integer.compare(s2.getValue(), s1.getValue()))
                  .forEach(e -> System.out.println(String.format("%s - %d", e.getKey(), e.getValue())));

    }
}
