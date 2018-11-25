import java.util.Scanner;

public class HalfSumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int max = Integer.MIN_VALUE;
        int sum =0;

        for (int i=1;i<=n;i++) {
            int num = Integer.parseInt(scanner.nextLine());
            sum += num;
            if (num>max) {
                max = num;
            }
        }
        int other = sum - max;
        if (other==max) {
            System.out.printf("Yes Sum = %d",other);
        }   else {
            System.out.printf("No Diff = %d",Math.abs(other-max));
        }
    }
}
