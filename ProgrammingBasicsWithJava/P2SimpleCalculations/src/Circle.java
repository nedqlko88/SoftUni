import java.util.Scanner;

public class Circle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double r = Double.parseDouble(scanner.nextLine());
        double area = Math.PI*Math.pow(r,2);
        double perimeter = 2 * r * Math.PI;
        System.out.printf("Area = %s%n",area);
        System.out.printf("Perimeter = %s%n",perimeter);

    }
}
