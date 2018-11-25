import java.util.Scanner;

public class Sunglasses {
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

        System.out.print(repeatStr("*", 2 * n ));
        System.out.print(repeatStr(" ",n));
        System.out.println(repeatStr("*", 2 * n ));
        for (int i = 0; i < n - 2; i ++) {
            System.out.print("*");
            System.out.print(repeatStr("/", (n + n - 2)));
            System.out.print("*");
            if ( i == ((n - 1)/2) - 1) {
                System.out.print(repeatStr("|",n));
            } else {
                System.out.print(repeatStr(" ",n));
            }
            System.out.print("*");
            System.out.print(repeatStr("/", (n + n - 2)));
            System.out.println("*");
        }
        System.out.print(repeatStr("*", 2 * n ));
        System.out.print(repeatStr(" ",n));
        System.out.println(repeatStr("*", 2 * n ));

    }
}
