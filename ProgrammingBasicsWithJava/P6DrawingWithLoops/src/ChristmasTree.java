import java.util.Scanner;

public class ChristmasTree {
    static String repeatStr(String strtoRepeat, int count) {
        String text = "";
        for (int i = 0; i < count; i++) {
            text = text + strtoRepeat;
        }
        return text;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        for (int row = 0; row <= n; row++) {
            String stars = repeatStr("*", row);
            String spaces = repeatStr(" ", n -row);
            System.out.print(spaces);
            System.out.print(stars);
            System.out.print(" | ");
            System.out.println(stars);
        }


    }
}
