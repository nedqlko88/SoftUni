import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class P02SumBigNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String longNum = reader.readLine();
        String shortNum = reader.readLine();

        if (shortNum.length() > longNum.length()) {
            String temp = longNum;
            longNum = shortNum;
            shortNum = temp;
        }

        StringBuilder sb = new StringBuilder();
        int remainder = 0;
        int longIndex = longNum.length() - 1;

        for (int i = shortNum.length() - 1; i >= 0; i--, longIndex--) {
            int firstDigit = shortNum.charAt(i) - '0';
            int secondDigit = longNum.charAt(longIndex) - '0';
            int currSum = firstDigit + secondDigit + remainder;

            if (currSum >= 10) {
                sb.append(currSum % 10);
                remainder = 1;
            } else {
                sb.append(currSum);
                remainder = 0;
            }
        }

        for (int i = longIndex; i >= 0; i--) {
            int secondDigit = longNum.charAt(i) - '0';
            int currSum = secondDigit + remainder;

            if (currSum >= 10) {
                sb.append(currSum % 10);
                remainder = 1;
            } else {
                sb.append(currSum);
                remainder = 0;
            }
        }
        if (remainder == 1) {
            sb.append(1);
            remainder = 0;
        }
        sb.reverse();
        int counter = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) != '0') {
                break;
            }
            counter++;
        }

        System.out.println(sb.substring(counter));



    }
}
