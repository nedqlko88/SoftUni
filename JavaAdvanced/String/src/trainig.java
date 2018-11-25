import java.util.Scanner;

public class trainig {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int sum = a / b;
        int sum1 = a % b;
        System.out.println(sum);
        System.out.println(sum1);
    }
}
