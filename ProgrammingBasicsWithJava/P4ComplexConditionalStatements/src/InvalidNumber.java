import java.util.Scanner;

public class InvalidNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        if ((input > 200 || input < 100) && input != 0) {
            System.out.println("invalid");
        }
    }
}
