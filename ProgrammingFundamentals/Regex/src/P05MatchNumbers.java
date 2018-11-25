import javafx.css.Match;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class P05MatchNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        final String regex = "(^|(?<=\\s))-?\\d+(.\\d+)?($|(?=\\s))";
        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(input);

        List<String> output = new ArrayList<>();

        while  (matcher.find()) {
            output.add(matcher.group());
        }
        System.out.println(String.join(" ",output));
    }
}
