import java.util.Scanner;

public class P05AddSubstract {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n1 = Integer.parseInt(scanner.nextLine());
        int n2 = Integer.parseInt(scanner.nextLine());
        int n3 = Integer.parseInt(scanner.nextLine());

        int result = substractNumbers(sum(n1, n2),n3);
        System.out.println(result);
    }

    private static int substractNumbers(int sum, int n3) {
        return sum - n3;
    }

    private static int sum(int n1, int n2) {
        return n1 + n2;
    }
}
