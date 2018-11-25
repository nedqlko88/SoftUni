import java.util.Scanner;

public class P08SpiceMustFLow {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long extractForDay = Long.parseLong(scanner.nextLine());
        long totalExtracted = 0L;
        int counterDays = 0;

        while (extractForDay >= 100) {
            totalExtracted += extractForDay - 26;
            counterDays++;
            extractForDay -= 10;

        }

        totalExtracted -= 26;
        if (totalExtracted < 0) {
            totalExtracted =0;
        }

        System.out.println(counterDays);
        System.out.println((totalExtracted));


    }
}
