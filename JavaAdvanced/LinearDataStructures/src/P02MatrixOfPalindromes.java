import java.util.Arrays;
import java.util.Scanner;

public class P02MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int r = input[0];
        int c = input[1];
        char[][][] matrix = new char[r][c][3];


        int a = 97;
        int b;

        for (int rows = 0; rows < r; rows++) {
            b = a;
            for (int cols = 0; cols < c; cols++) {
                    matrix[rows][cols][0] = (char) a;
                    matrix[rows][cols][1] = (char) b;
                    matrix[rows][cols][2] = (char) a;
                    b++;
            }
            a++;

        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                for (int k = 0; k < 3; k++) {
                    System.out.printf("%s", matrix[i][j][k]);
                }
                System.out.print(" ");
            }
            System.out.println();

        }
    }



}


