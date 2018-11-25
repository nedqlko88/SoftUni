import java.util.Scanner;

public class P01Train {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] input = new int[n];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            input[i] = Integer.parseInt(scanner.next());
            sum += input[i];
        }

        for (int i : input) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        System.out.println(sum);

    }
}
