import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class P02CommonElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        int[] array = Arrays.stream(input.split("!")).mapToInt(Integer::parseInt).toArray();

        System.out.println("ggg");




//        Scanner scanner = new Scanner(System.in);
//        String[] array1 = scanner.nextLine().split(" ");
//        String[] array2 = scanner.nextLine().split(" ");
//
//        for (String a2 : array2) {
//            for (String a1 : array1) {
//                if (a2.equals(a1)) {
//                    System.out.printf("%s ", a2);
//                }
//            }
//
//        }
    }
}
