import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p06CardsGame {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> first = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        List<Integer> second = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        while (true) {
            int currCard1 = first.get(0);
            int currCard2 = second.get(0);
            if (currCard1 > currCard2) {
                first.add(currCard1);
                first.add(currCard2);
            } else if (currCard1 < currCard2) {
                second.add(currCard2);
                second.add(currCard1);
            }
            first.remove(0);
            second.remove(0);
            if (first.isEmpty()) {
            System.out.printf("Second player wins! Sum: %d", second.stream().mapToInt(Integer::intValue).sum());
                break;
            }
            if (second.isEmpty()) {
            System.out.printf("First player wins! Sum: %d", first.stream().mapToInt(Integer::intValue).sum());
            break;

            }
        }
    }
}
