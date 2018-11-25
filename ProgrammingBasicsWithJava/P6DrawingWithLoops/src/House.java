import java.sql.SQLOutput;
import java.util.Scanner;

public class House {
    static String repeatStr(String symbol, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + symbol;
        }
        return text;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int row=0; row < (n + 1) / 2; row++) {
            System.out.print(repeatStr("-",((n + 1) / 2)-1-row));
            if ( n % 2 == 0) {
                System.out.print(repeatStr("*", 2 + row * 2));
            } else {
                System.out.print(repeatStr("*", 1 + row * 2));
            }
            System.out.print(repeatStr("-",((n + 1) / 2)-1-row));
            System.out.println("");
        }
        for (int row=0; row < n / 2; row++) {
            System.out.print("|");
            System.out.print(repeatStr("*", n - 2));
            System.out.println("|");
        }

    }
}
