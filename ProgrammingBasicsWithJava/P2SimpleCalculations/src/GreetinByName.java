import java.util.Scanner;

public class GreetinByName {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.printf("Hello, %s!", name);

    }
}
