import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Double, Integer> map = new HashMap<>();
        double[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble)
                .toArray();

        for (double v : input) {

            if (!map.containsKey(v)) {
                map.put(v, 0);
            }
            map.put(v, map.get(v) + 1);
        }
        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%s  %d - times%n", entry.getKey(), entry.getValue());
        }
    }
}
