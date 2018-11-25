import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P10MatchPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phone = reader.readLine();
        String regex = "^\\+359([ |-])2\\1\\d{3}\\1\\d{4}$";
        Pattern pattern = Pattern.compile(regex);

        while (!"end".equals(phone)) {
            Matcher matcher = pattern.matcher(phone);
            if (matcher.find()) {
                System.out.println(phone);
            }
            phone = reader.readLine();
        }
    }
}
