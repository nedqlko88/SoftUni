import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class P08BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        int elementsToPush = firstLine[0];
        int elementsToPop = firstLine[1];
        int numberToFind = firstLine[2];

        int[] secondLine = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        for (int i : secondLine) {
            deque.push(i);
        }
        for (int i = 0; i < elementsToPop; i++) {
            if (deque.isEmpty()) {
                break;
            }
            deque.pop();
        }
        if (deque.isEmpty()) {
            System.out.println(0);
        } else if (deque.contains(numberToFind)) {
            System.out.println("true");
        }  else {
            System.out.println(Collections.min(deque));
        }

    }
}
