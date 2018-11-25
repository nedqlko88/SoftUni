import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class P06MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new LinkedHashMap<>();
        String resource = scanner.nextLine();

        while (!"stop".equals(resource)) {
            int quantity = Integer.parseInt(scanner.nextLine());

            if (!map.containsKey(resource)) {
                map.put(resource, quantity);
            } else {
                map.put(resource, map.get(resource) + quantity);
            }
            resource = scanner.nextLine();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.printf("%s -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
