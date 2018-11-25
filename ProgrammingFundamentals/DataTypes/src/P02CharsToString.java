import java.util.Scanner;

public class P02CharsToString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String firstInput = scanner.nextLine();
        String secondInput = scanner.nextLine();
        String thirdInput = scanner.nextLine();
        String result = firstInput + secondInput + thirdInput;

        System.out.println(result);
    }
}
