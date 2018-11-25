import java.util.Scanner;

public class P09PokeMan {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int m = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
        int counter = 0;
        int half = 0;
        if (n % 2 == 0) {
            half = n / 2;
        }


        while (n >= m) {
            if (n == half && y != 0) {
                n /= y;
            }
            if (n >= m) {
                n -= m;
                counter++;
            }
        }

        System.out.println(n);
        System.out.println(counter);
    }
}
