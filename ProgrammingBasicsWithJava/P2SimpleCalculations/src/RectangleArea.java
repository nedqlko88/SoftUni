import java.util.Scanner;

public class RectangleArea {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = Double.parseDouble(scanner.nextLine());
        double y1 = Double.parseDouble(scanner.nextLine());
        double x2 = Double.parseDouble(scanner.nextLine());
        double y2 = Double.parseDouble(scanner.nextLine());
        double a = Math.max(x1,x2) - Math.min(x1,x2);
        double b = Math.max(y1,y2) - Math.min(y1,y2);
        double square = a * b;
        double perimeter = (a + b) * 2;
        System.out.println(square);
        System.out.println(perimeter);

    }
}
