import java.util.Scanner;

public class minNumber {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int n = Integer.parseInt(scanner.nextLine());
            int min=Integer.MAX_VALUE;
            for (int i =0; i< n;i++) {
                int a = Integer.parseInt(scanner.nextLine());
                if (a < min) {
                    min = a;
                }

            }
            System.out.println(min);
        }
    }


