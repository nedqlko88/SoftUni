import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

public class P02CharacterMultiplier {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        String longWord = input[0];
        String shortWord = input[1];
        int sum = calculateSum(longWord, shortWord);
        System.out.println(sum);
    }

    private static int calculateSum(String longWord, String shortWord) {
        int sum = 0;
        int diffInSize = Math.abs(shortWord.length() - longWord.length());
        if (shortWord.length() > longWord.length()) {
            String temp = shortWord;
            shortWord = longWord;
            longWord = temp;
        }

        for (int i = 0; i < shortWord.length(); i++) {
            sum += shortWord.charAt(i) * longWord.charAt(i);
        }

        for (int i = shortWord.length(); i < longWord.length(); i++) {
            sum += longWord.charAt(i);
        }

        return sum;
    }
}
