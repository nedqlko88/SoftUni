import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P03TextFilter {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] words = reader.readLine().split(", ");
        String inputText = reader.readLine();
        StringBuilder sb = new StringBuilder();
        sb.append(inputText);

        for (String word : words) {
//            System.out.println(word);
            Pattern pattern = Pattern.compile(word);
            Matcher matcher = pattern.matcher(sb);
            int lenght = word.length();
            StringBuilder crypt = new StringBuilder();
            for (int j = 0; j < lenght; j++) {
                crypt.append("*");
            }

            while (matcher.find()) {
                int i = sb.indexOf(word);
//                System.out.println(i);
                sb.replace(i, i + lenght, crypt.toString());
            }
        }
        System.out.println(sb);
    }
}
