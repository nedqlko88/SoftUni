import java.util.Arrays;
import java.util.Scanner;

public class P03ZigZagArrays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] arrayOne = new int[n];
        int[] arrayTwo = new int[n];
        for (int i = 0; i < n; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (i % 2 == 0) {
                arrayOne[i] = input[1];
                arrayTwo[i] = input[0];
            } else {
                arrayOne[i] = input[0];
                arrayTwo[i] = input[1];
            }
        }
        for (int i : arrayTwo) {
            System.out.printf("%d ", i);
        }
        System.out.println();
        for (int i : arrayOne) {
            System.out.printf("%d ", i);
        }
        }
}
