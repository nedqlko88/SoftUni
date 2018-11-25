import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P07StudentAcademy {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
           int n = Integer.parseInt(reader.readLine());

           Map<String, List<Double>> students = new LinkedHashMap<>();

           while (n-- > 0) {
               String name = reader.readLine();
               double grade = Double.parseDouble(reader.readLine());

               if (!students.containsKey(name)) {
                   students.put(name, new ArrayList<>());
               }

               students.get(name).add(grade);
           }

           students.entrySet().stream()
                   .filter(e -> e.getValue().stream().mapToDouble(Double::valueOf).average().getAsDouble() >= 4.5)
                   .sorted((s1, s2) -> {
                       double average1 = 0;
                       double average2 = 0;

                       for (Double grade : s1.getValue()) {
                            average1 += grade;
                       }
                       average1 = average1 / s1.getValue().size();

                       for (Double grade : s2.getValue()) {
                           average2 += grade;
                       }
                       average2 = average2 / s2.getValue().size();

                       if (average2 > average1) {
                           return 1;
                       } else if (average2 < average1) {
                           return -1;
                       } else {
                           return 0;
                       }

                   }).forEach(e -> System.out.println(String.format("%s -> %.2f", e.getKey(), e.getValue().stream().mapToDouble(Double::valueOf).average().getAsDouble())));



    }
}
