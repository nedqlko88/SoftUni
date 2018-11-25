import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04UnicodeCharacters {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder text = new StringBuilder();
        text.append(input);

        for (int i = 0; i < text.length(); i++) {
            int ss = text.codePointAt(i);
            System.out.printf("\\u00%s", Integer.toHexString(ss));

        }

    }
}
