import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P08LettersChange {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\s+");
        double sum = 0;

        for (String token : tokens) {
            char firstLetter = token.charAt(0);
            char lastLetter = token.charAt(token.length() - 1);
            int firstUpper = firstLetter - 64;
            int firstLower = firstLetter - 96;
            int lastUpper = lastLetter - 64;
            int lastLower = lastLetter - 96;
            double number = Double.parseDouble(token.substring(1, token.length() - 1));
            double sum1 = 0;
            double sum2 = 0;

            if (Character.isUpperCase(firstLetter)) {
                sum1 = number / firstUpper;
            } else if (Character.isLowerCase(firstLetter)){
                sum1 = number * firstLower;
            }

            if (Character.isUpperCase(lastLetter)) {
                sum2 = sum1 - lastUpper;
            } else if (Character.isLowerCase(lastLetter)){
                sum2 = sum1 + lastLower;
            }

            sum += sum2;
        }
        System.out.printf("%.2f", sum);
    }
}
