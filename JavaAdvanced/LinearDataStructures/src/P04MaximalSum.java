import java.util.Arrays;
import java.util.Scanner;

public class P04MaximalSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size = scanner.nextLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);
        int[][] matrix = new int[n][m];

        for (int rows = 0; rows < n; rows++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int cols = 0; cols < m; cols++) {
                matrix[rows][cols] = input[cols];
            }
        }

        int bestStartRow = 0;
        int bestStartCol = 0;
        int bestSum = Integer.MIN_VALUE;
        for (int row = 0; row <= n - 3; row++) {
            for (int col = 0; col <= m - 3; col++) {
                int currentSum = 0;
                for (int i = 0; i < 3; i++) {
                    for (int j = 0; j < 3; j++) {
                        currentSum += matrix[row + i][col + j];
                    }
                }
                if (currentSum > bestSum) {
                    bestSum = currentSum;
                    bestStartRow = row;
                    bestStartCol = col;
                }
            }
        }
        System.out.printf("Sum = %d%n", bestSum);
        for (int i = bestStartRow; i < bestStartRow + 3; i++) {
            for (int j = bestStartCol; j < bestStartCol + 3; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
