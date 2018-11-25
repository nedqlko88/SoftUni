import java.util.Arrays;
import java.util.Scanner;


public class P05MatrixShuffling {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = input[j];
            }
        }

        String command;
        while (true) {
            if ("END".equals(command = scanner.nextLine())) {
                break;
            }


            String[] line = command.split("\\s+");


            if (line.length != 5 || !"swap".equals(line[0]) || notNumber(line)) {
                System.out.println("Invalid input!");
            } else {

                int row1 = Integer.parseInt(line[1]);
                int col1 = Integer.parseInt(line[2]);
                int row2 = Integer.parseInt(line[3]);
                int col2 = Integer.parseInt(line[4]);

                if (row1 >= rows || row2 >= rows || col1 >= cols || col2 >= cols) {
                    System.out.println("Invalid input!");
                } else {
                    String temp = matrix[row1][col1];
                    matrix[row1][col1] = matrix[row2][col2];
                    matrix[row2][col2] = temp;

                    for (int row = 0; row < rows; row++) {
                        for (int col = 0; col < cols; col++) {
                            System.out.printf("%s ", matrix[row][col]);
                        }
                        System.out.println();
                    }
                }
            }
        }

    }

    private static boolean notNumber(String[] line) {
        boolean notNumber = false;
        for (int i = 1; i < line.length; i++) {
            for (int j = 0; j < line[i].length(); j++) {
                if (!Character.isDigit(line[i].charAt(j))) {
                    notNumber = true;
                }
            }
        }
        return notNumber;
    }


}

