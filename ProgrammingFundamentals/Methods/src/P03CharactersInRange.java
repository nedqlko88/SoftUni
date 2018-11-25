import java.util.Scanner;

public class P03CharactersInRange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int downRange = scanner.nextLine().charAt(0);
        int upperRange = scanner.nextLine().charAt(0);
        int tempRange;
        if (downRange > upperRange) {
            tempRange = upperRange;
            upperRange = downRange;
            downRange = tempRange;
        }

        String s = printRangeCharacters(downRange, upperRange);
        System.out.println(s);
    }

    private static String printRangeCharacters(int downRange, int upperRange) {
        StringBuilder sb = new StringBuilder();
        for (int i = downRange + 1; i < upperRange; i++) {
            char currChar = (char) i;
            sb.append(currChar).append(" ");
        }

        return sb.toString();
    }
}
