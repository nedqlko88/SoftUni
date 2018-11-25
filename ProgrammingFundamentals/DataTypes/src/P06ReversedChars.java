import java.util.Scanner;

public class P06ReversedChars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = new String[3];
        for (int i = 0; i < 3; i++) {
            input[i] = scanner.nextLine();
        }
        for (int i = 2; i >=0 ; i--) {
            System.out.printf("%s ", input[i]);
        }
    }
}
