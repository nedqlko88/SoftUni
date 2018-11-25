import java.util.Scanner;

public class Diamond {
    static String repeatStr(String symbol, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + symbol;
        }
        return text;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        if (n % 2 == 0) {
            for (int row = 0; row < (n + 1) / 2; row++) {
                System.out.print(repeatStr("-", ((n - 1) / 2) - row));
                System.out.print("*");
                System.out.print(repeatStr("-", n - 2 * ((n - 1) / 2 - row) - 2));
                System.out.print("*");
                System.out.println(repeatStr("-", ((n - 1) / 2) - row));
            }
            for (int row = (n - 1) / 2; row > 0; row--) {
                System.out.print(repeatStr("-", ((n + 1) / 2) - row));
                System.out.print("*");
                System.out.print(repeatStr("-", n - 2 * ((n + 1) / 2 - row) - 2));
                System.out.print("*");
                System.out.println(repeatStr("-", ((n + 1) / 2) - row));

            }
        }
           else if ((n % 2 != 0 && n > 1))   {
            for (int row = 0; row < (n + 1) / 2 ; row++) {
                System.out.print(repeatStr("-",((n-1) / 2) - row));
                if (row == 0) {
                    System.out.print("*");
                    System.out.println(repeatStr("-",((n-1) / 2) - row));
                }   else {
                    System.out.print("*");
                    System.out.print(repeatStr("-", n - 2 * ((n-1) / 2 - row) - 2));
                    System.out.print("*");
                    System.out.println(repeatStr("-",((n-1) / 2) - row));
                }

            }
            for (int row = (n - 1) / 2; row > 1 ; row--) {
                System.out.print(repeatStr("-",((n + 1) / 2) - row));
                System.out.print("*");
                System.out.print(repeatStr("-", n - 2 * ((n + 1) / 2 - row) - 2));
                System.out.print("*");
                System.out.println(repeatStr("-",((n + 1) / 2) - row));
            }
            System.out.print(repeatStr("-",((n + 1) / 2) - 1));
            System.out.print("*");
            System.out.println(repeatStr("-",((n + 1) / 2) - 1));


        } else {
            System.out.println("*");
        }
    }
}
