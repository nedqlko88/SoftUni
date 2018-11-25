import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P01CountChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        Map<Character, Integer> map = new LinkedHashMap<>();
        for (String word : input) {
            for (int i = 0; i < word.length(); i++) {
                char letter = word.charAt(i);
                if (map.containsKey(letter)) {
                    map.put(letter, map.get(letter) + 1);
                }
                map.putIfAbsent(letter, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            System.out.println(String.format("%s -> %d", entry.getKey(), entry.getValue()));
        }
    }
}
