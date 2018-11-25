import java.util.Scanner;

public class time15Minutes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int inHours = Integer.parseInt(sc.nextLine());
        int inMinutes = Integer.parseInt(sc.nextLine());
        int newMinutes = inMinutes + 15;
        if (newMinutes > 59) {
            newMinutes -= 60;
            inHours += 1;
        }
        if (inHours > 23) {
            inHours -= 24;
        }
        if (newMinutes < 10) {
            System.out.printf("%d:0%d",inHours,newMinutes);
        } else {
            System.out.printf("%d" +
                    ":%d",inHours,newMinutes);
        }
    }
}
