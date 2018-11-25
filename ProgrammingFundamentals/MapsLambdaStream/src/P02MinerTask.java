import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P02MinerTask {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Integer> map = new LinkedHashMap<>();
        String line;
        while (!"stop".equals(line = reader.readLine())) {

            int quantity = Integer.parseInt(reader.readLine());

            if (map.containsKey(line)) {
                map.put(line, map.get(line) + quantity);
            }

            map.putIfAbsent(line, quantity);
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
