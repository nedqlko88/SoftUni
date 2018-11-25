import java.util.Scanner;

public class P06MiddleCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String result = findMiddle(input);

        System.out.println(result);
    }

    private static String findMiddle(String input) {
        String middle = "";

        if (input.length() % 2 == 0) {
            int start = input.length() / 2 - 1;
            int end = input.length() / 2 + 1;
            middle = input.substring(start, end);
        } else  {
            int center = input.length() / 2;
            middle = input.substring(center, center + 1);
        }
        return middle;
    }
}
