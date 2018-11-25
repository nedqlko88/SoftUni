import java.util.Scanner;

public class PointInRectangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Double x1 = Double.parseDouble(scanner.nextLine());
        Double y1 = Double.parseDouble(scanner.nextLine());
        Double x2 = Double.parseDouble(scanner.nextLine());
        Double y2 = Double.parseDouble(scanner.nextLine());
        Double x = Double.parseDouble(scanner.nextLine());
        Double y = Double.parseDouble(scanner.nextLine());
        if (x >= x1 && x <=x2 && y >= y1 && y <= y2) {
            System.out.println("Inside");
        } else {
            System.out.println("Outside");
        }

    }
}
