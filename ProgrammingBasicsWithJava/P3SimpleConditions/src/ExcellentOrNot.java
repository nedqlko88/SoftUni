import java.util.Scanner;

public class ExcellentOrNot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double console = Double.parseDouble(scanner.nextLine());
        if (console >= 5.5) {
            System.out.println("Excellent!");
        } else {
            System.out.println("Not excellent.");
        }
    }
}
