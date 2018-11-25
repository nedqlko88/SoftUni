import java.util.Scanner;

public class P08Factorial {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());

        double result = calcDivision(n1,n2);
        System.out.printf("%.2f", result);
    }

    private static double calcDivision(int n1, int n2) {
        double result = calcFactorial(n1) * 1.0 / calcFactorial(n2);
    return result;
    }
    private static long calcFactorial(int n2) {
        long result = 1;
        for (int i = 1; i <= n2; i++) {
            result *= i;
        }
        return result;
    }
}
