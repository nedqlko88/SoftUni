import java.util.Scanner;

public class SquareFrame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        System.out.print("+");
        for (int row = 0; row < n - 2; row++) {
            System.out.print(" -");
        }
        System.out.println(" +");
        for (int i = 0; i < n-2; i++) {
            for (int col = 0; col < n - 2; col++) {
                if (col == 0) {
                    System.out.print("|");
                }
                System.out.print(" -");
                if (col == (n - 3)) {
                    System.out.println(" |");
                }
            }
        }
        System.out.print("+");
        for (int row = 0; row < n - 2; row++) {
            System.out.print(" -");
        }
        System.out.println(" +");

    }
}
