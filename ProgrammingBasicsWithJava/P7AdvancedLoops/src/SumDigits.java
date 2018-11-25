import java.util.Scanner;

public class SumDigits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        int sum = 0;
        do {
            sum += m % 10;
            m = m / 10;
        }   while (m > 0);
        System.out.println(sum);
    }
}
