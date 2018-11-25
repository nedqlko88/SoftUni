import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class P06RepeatingChars {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < input.length(); i++) {
           if (input.charAt(i - 1) != input.charAt(i)) {
               sb.append(input.charAt(i - 1));
           }
        }
        if (sb.charAt(sb.length() - 1) != input.charAt(input.length() - 1)) {
            sb.append(input.charAt(input.length() - 1));
        }


        System.out.println(sb.toString());


    }
}
