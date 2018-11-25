import java.sql.SQLOutput;
import java.util.Scanner;

public class BonusScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int console = Integer.parseInt(scanner.nextLine());
        double bonus1 = 0;
        double bonus2 = 0;
        double total = 0;
        int check = console / 5;
        if (console <= 100) {
            bonus1 = 5;
        } else {
            if ((console > 100) && (console <= 1000)) {
                bonus1 = 0.2*console;


            } else {
                if (console > 1000) {
                    bonus1 = 0.1 * console;
                }
            }
        }
        if (console % 2 == 0) {
            bonus2 = 1;
        } else {
            if ((console % 5 == 0) && (check % 2 != 0)) {
                bonus2 = 2;
            }
        }
        total = console + bonus1 + bonus2;
        System.out.println(bonus1+bonus2);
        System.out.println(console+bonus1+bonus2);
    }
}
