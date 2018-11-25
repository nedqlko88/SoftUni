import java.util.Arrays;
import java.util.Scanner;

public class P03DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            int[] lines = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int j = 0; j < n; j++) {
                matrix[i][j] = lines[j];
            }
        }

        int rightDiagonal = findRight(matrix);
        int leftDiagonal = findLeft(matrix);
        int result = leftDiagonal - rightDiagonal;
        System.out.println(Math.abs(result));


    }

    private static int findRight(int[][] matrix) {
        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            int count = matrix.length - 1 - rows;
            sum += matrix[rows][count];
        }
        return sum;
    }

    private static int findLeft(int[][] matrix) {
        int sum = 0;

        for (int rows = 0; rows < matrix.length; rows++) {
            sum += matrix[rows][rows];
        }
        return sum;
    }
}
