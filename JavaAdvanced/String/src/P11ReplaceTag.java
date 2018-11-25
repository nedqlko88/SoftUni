import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P11ReplaceTag {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        StringBuilder text = new StringBuilder();

        while  (!"END".equals(input = reader.readLine())) {
            text.append(input).append(System.lineSeparator());
        }

        String replacement = "[URL href=$1]$2[/URL]";
        String regex = "<a.*?href.*?=(.*)>(.*?)</a>";
        Pattern pattern = Pattern.compile(regex);
        String result = text.toString().replaceAll(regex, replacement);

        result = result.replaceAll(" {2}", "\n");

        System.out.println(result);
    }
}


