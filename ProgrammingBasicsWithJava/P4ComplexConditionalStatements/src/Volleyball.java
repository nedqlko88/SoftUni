import java.text.DecimalFormat;
import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");
        String  year = scanner.nextLine();
        int p = Integer.parseInt(scanner.nextLine());
        int h = Integer.parseInt(scanner.nextLine());
        double sum = ((48 - h) * 0.75) + h + (p * 0.6667);
        double a = 3 /4.0;
      if (year.equalsIgnoreCase("normal")) {
                System.out.printf("%s", formatter.format(Math.floor(sum)));
      } else if (year.equalsIgnoreCase("leap")) {
          System.out.printf("%s%n", formatter.format(Math.floor((sum) * 1.15)));
          System.out.println(a);
      }


    }
}
