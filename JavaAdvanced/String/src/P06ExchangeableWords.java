import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P06ExchangeableWords {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String shortWord = input[0];
        String longWord = input[1];
        if (shortWord.length() > longWord.length()) {
            String temp = longWord;
            longWord = shortWord;
            shortWord = temp;
        }
        boolean isExchangeable;
        Map<Character, Character> map = new LinkedHashMap<>();

        isExchangeable = checkExchangeability(shortWord, longWord, map);

        System.out.println(isExchangeable);

    }

    private static boolean checkExchangeability(String shortWord, String longWord, Map<Character, Character> map) {
        int count = 0;
        for (int i = 0; i < shortWord.length(); i++, count++) {
            if (!map.containsKey(shortWord.charAt(i))) {
                if (map.containsValue(longWord.charAt(i))) {
                    return false;
                }
                map.put(shortWord.charAt(i), longWord.charAt(i));
            } else {
                if ((map.get(shortWord.charAt(i)) != longWord.charAt(i))) {
                    return false;
                }
            }
        }

        if (shortWord.length() < longWord.length()) {
            for (int i = count; i < longWord.length(); i++) {
                if (!map.containsValue(longWord.charAt(i))) {
                    return false;
                }
            }
        }

        return true;

    }


}
