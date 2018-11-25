import java.util.Scanner;

public class P01SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        int sum = 0;

        for (int i = 0; i < input.length(); i++) {
            sum += Integer.parseInt(input.charAt(i) + "");
        }
        System.out.println(sum);
    }
}
