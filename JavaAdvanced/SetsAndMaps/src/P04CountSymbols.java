import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class P04CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<String, Integer> map = new TreeMap<>();

        for (int i = 0; i < input.length(); i++) {
            if (!map.containsKey(input.charAt(i) + "")) {
                map.put(input.charAt(i) + "", 1);
            } else {
                map.put(input.charAt(i) + "", map.get(input.charAt(i) + "") + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {

            System.out.printf("%s: %d time/s%n", entry.getKey(), entry.getValue());
        }

    }
}
