import java.util.Scanner;

public class P04MetersToKms {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int meters = Integer.parseInt(scanner.nextLine());
        double kms = (double) meters / 1000;
        System.out.printf("%.2f", kms);
    }
}
