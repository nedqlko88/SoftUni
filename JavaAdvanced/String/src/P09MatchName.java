import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P09MatchName {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        String regex = "^[A-Z][a-z]+ [A-Z][a-z]+$";
        Pattern pattern = Pattern.compile(regex);

        while (!"end".equals(name)) {
            final Matcher matcher = pattern.matcher(name);
            if (matcher.find()) {
                System.out.println(matcher.group());
            }
            name = reader.readLine();
        }
    }
}
