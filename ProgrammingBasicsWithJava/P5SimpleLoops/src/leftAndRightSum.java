import java.util.Scanner;

public class leftAndRightSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int leftSum=0;
        int rightSum=0;
        for (int i=0;i<n;i++) {
            int a = Integer.parseInt(scanner.nextLine());
            leftSum += a;
        }

        for (int i=0;i<n;i++) {
            int a = Integer.parseInt(scanner.nextLine());
            rightSum += a;
        }
        if (Math.abs(leftSum - rightSum) == 0) {
            System.out.printf("Yes, sum = %d",leftSum);

        } else {
            System.out.printf("No, diff = %d",Math.abs(leftSum - rightSum));
        }
    }


}
