import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class P02StudentsByFirstAndLast {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<String[]> students = new ArrayList<>();

        while (!"END".equals(input = reader.readLine())) {
            String[] names = input.split("\\s+");
            students.add(names);
        }
        students.stream()
                .filter(a -> {
                    if (a[0].compareTo(a[1]) < 0) {
                        return true;
                    }
                    return false;
                }).forEach(a -> System.out.printf("%s %s%n",a[0], a[1]));

    }
}
//    int first = a.getKey().charAt(0);
//    int last = a.getValue().charAt(0);
//                    if (first < last) {
//        return true;
//        }
//        return false;