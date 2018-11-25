import java.util.Scanner;

public class LiveDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        String value = String.format("%1$-10.1f || %2$10.1f", 1.26, 5.55);
//        System.out.println(value);

        String[] input = scanner.nextLine().split("[,\\s-]+");

        double avg = 0;
        for (int i = 1; i < input.length; i++) {
            avg += Double.parseDouble(input[i]);
            if (i == input.length -1) {
                avg /= 3;
            }
        }
//        Name      |   JAdv|JavaOOP| AdvOOP|Average|
        double adv = Double.parseDouble(input[1]);
        double oop = Double.parseDouble(input[2]);
        double advOOP = Double.parseDouble(input[3]);
        System.out.printf("%1$-10s|%2$7s|%3$7s|%4$7s|%5$7s|%n", "Name", "JAdv", "JavaOOP", "AdvOOP", "Average");
        System.out.printf("%1$-10s|%2$7.2f|%3$7.2f|%4$7.2f|%5$7.2f|", input[0], adv, oop, advOOP, avg);
    }
}
