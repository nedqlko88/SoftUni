import javafx.css.StyleConverter;

import java.util.Scanner;

public class P10TopNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String n = scanner.nextLine();
        int number = Integer.parseInt(n);

        for (int i = 1; i <= number; i++) {
            if (sumOfDigits(i)) {
                System.out.println(i);

            }
        }
    }



    private static boolean sumOfDigits(int i) {
        int sum = 0;
        boolean odd = false;

        while (i > 0) {
            int currNumber = i % 10;
            if (currNumber % 2 != 0) {
                odd = true;
            }
            i = i / 10;
            sum += currNumber;
        }

        if (sum % 8 == 0 && odd) {
            return true;
        }
        return false;
    }
}
