import java.util.Scanner;

public class oddEvenSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumOdd = 0;
        int sumEven = 0;
        int n = Integer.parseInt(scanner.nextLine());
        for (int i=1;i<=n;i++) {
            int a = Integer.parseInt(scanner.nextLine());
            if (i % 2 == 0) {
                sumEven += a;
            } else  {
                sumOdd += a;
            }
        }
        if (sumEven==sumOdd) {
            System.out.printf("Yes Sum = %d",sumEven);
        } else {
            System.out.printf("No Diff = %d",Math.abs(sumEven-sumOdd));

        }

    }
}
