import java.util.Scanner;

public class areaOfFigures {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String figure = scanner.nextLine();
        if ("square".equalsIgnoreCase(figure)) {
            double insquare = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",insquare * insquare);
        } else if ("rectangle".equalsIgnoreCase(figure)) {
            double side1 = Double.parseDouble(scanner.nextLine());
            double side2 = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",side1 * side2);
        } else if ("circle".equalsIgnoreCase(figure)) {
            double radius = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f", Math.PI * Math.pow(radius, 2));
        } else if ("triangle".equalsIgnoreCase(figure)) {
            double side = Double.parseDouble(scanner.nextLine());
            double heigh = Double.parseDouble(scanner.nextLine());
            System.out.printf("%.3f",(side * heigh)/2);
        }
    }
}
