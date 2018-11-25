import java.util.ArrayList;
        import java.util.List;
        import java.util.Scanner;
        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

public class P02MatchPhoneNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        final   String regex = "\\+359([-| ])2\\1\\d{3}\\1\\d{4}\\b";
        final Pattern patern = Pattern.compile(regex);
        final Matcher matcher = patern.matcher(input);

        List<String> matches = new ArrayList<>();

        while (matcher.find()) {
            matches.add(matcher.group());
        }
        System.out.println(String.join(", ",matches));
    }
}

