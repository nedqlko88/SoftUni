import java.util.Scanner;

public class P01FillTheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(", ");

        int size = Integer.parseInt(input[0]);
        int[][] filledMatrix = new int[size][size];
        if (input[1].equals("A")) {
            filledMatrix = fillMatrixA(size);
        } else {
            filledMatrix = fillMatrixB(size);
        }
        printMatrix(filledMatrix, size);

    }

    private static void printMatrix(int[][] matrixToPrint, int size) {
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < size; col++) {
                System.out.printf("%d ", matrixToPrint[row][col]);
            }
            System.out.println();
        }

    }

    private static int[][] fillMatrixB(int size) {
        int[][] matrixB = new int[size][size];
        int count = 1;
        for (int col = 0; col < size; col++) {
            if (col % 2 == 0) {
                for (int oddRow = 0; oddRow < size; oddRow++) {
                    matrixB[oddRow][col] = count;
                    count++;
                }
            } else {
                for (int evenRow = size - 1; evenRow >= 0 ; evenRow--) {
                    matrixB[evenRow][col] = count;
                    count++;
                }
            }

        }
        return matrixB;
    }

    private static int[][] fillMatrixA(int size) {

        int[][] matrixA = new int[size][size];
        int count = 1;
        for (int cols = 0; cols < size; cols++) {
            for (int rows = 0; rows < size; rows++) {
                matrixA[rows][cols] = count;
                count++;
            }
        }
        return matrixA;
    }
}
