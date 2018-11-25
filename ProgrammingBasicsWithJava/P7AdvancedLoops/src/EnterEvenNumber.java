import java.util.Scanner;

public class EnterEvenNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = 0;

        while (true)
        {
            try {
                System.out.println("Enter even number:");
                String input = scanner.nextLine();
                n = Integer.parseInt(input);
                if (n % 2 == 0) {
                    System.out.printf("Even number entered: %d", n);
                    break;
                } else {
                    System.out.println("The number is not even.");
                }
            } catch (Exception e) {
                System.out.println("Invalid number!");
            }
        }

    }
}
