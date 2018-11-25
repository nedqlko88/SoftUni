import java.util.Scanner;

public class Fibonacci {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int f0 = 1;
        int f1 = 1;
        int fib = 0;
        if  (n < 2) {
            fib = 1;
        }   else {
            for ( int i = 1; i < n; i++) {
                fib = f0 + f1;
                f0=f1;
                f1 = fib;
            }
        }
        System.out.println(fib);
    }
}
