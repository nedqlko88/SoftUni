import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class P09Palindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input;
        while (!"END".equals(input = scanner.nextLine())) {
            System.out.println(isPolindrome(input));
        }
    }

    private static boolean isPolindrome(String input) {
        char[] reversedInput = new char[input.length()];
        int j = 0;
        for (int i = input.length() - 1; i >= 0; i--, j++) {
            reversedInput[i] = input.charAt(j);
        }

        for (int i = 0; i < input.length(); i++) {
            if (reversedInput[i] != input.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
