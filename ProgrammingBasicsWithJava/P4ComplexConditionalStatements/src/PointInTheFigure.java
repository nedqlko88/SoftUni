import java.util.Scanner;

public class PointInTheFigure {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int h = Integer.parseInt(scanner.nextLine());
        int x = Integer.parseInt(scanner.nextLine());
        int y = Integer.parseInt(scanner.nextLine());
       if (((x > 0 && x < 3 * h) && (y > 0 && y < h)) || ((x > h && x < 2 * h) && (y > 0 && y < 4 * h))) {
            System.out.println("inside");
        } else  if (((x < 0 || x > 3 * h) || (y < 0 || y > h)) && ((x < h || x > 2 * h) || (y < 0 || y > 4 * h))) {
           System.out.println("outside");
       } else   {
           System.out.println("border");
       }
    }
}
