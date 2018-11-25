import java.util.Scanner;

public class P07Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        int[][] matrix = makeMatrix(n);

        printMatrix(matrix);

    }

    private static void printMatrix(int[][] matrix) {
        for (int rows = 0; rows < matrix.length; rows++) {
            for (int cols = 0; cols < matrix.length; cols++) {
                System.out.printf("%d ", matrix[rows][cols]);
            }
            System.out.println();
        }
    }

    private static int[][] makeMatrix(int n) {
        int[][] newMatrix = new int[n][n];

        for (int rows = 0; rows < n; rows++) {
            for (int cols = 0; cols < n; cols++) {
                newMatrix[rows][cols] = n;
            }
        }
        return newMatrix;
    }
}
