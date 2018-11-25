import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int fact = 1;

        while ( n > 0) {
            fact *= n;
            n--;
        }
        System.out.println(fact);
    }
}
