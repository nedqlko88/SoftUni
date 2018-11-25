import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String typeProjection = scanner.nextLine();
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        double sum = 0;
        switch (typeProjection) {
            case "Premiere":
                sum = rows * cols * 12;
                System.out.printf("%.2f leva",sum);
            case "Normal":
                sum = rows * cols * 7.5;
                System.out.printf("%.2f leva",sum);
            case "Discount":
                sum = rows * cols * 5;
                System.out.printf("%.2f leva",sum);
        }
    }
}
