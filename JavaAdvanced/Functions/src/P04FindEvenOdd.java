import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class P04FindEvenOdd {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
        .mapToInt(Integer::parseInt)
        .toArray();

        String command = reader.readLine();

        List<Integer> result = new ArrayList<>();
        result = findsList(input, command);

    }
    private static List<Integer> findsList(int[] input, String command) {
        Predicate<String> isEven = "even"::equals;
        List<Integer> listForAppends = new ArrayList<>();
        int n1 = input[0];
        int n2 = input[1];

        for (int i = n1; i <= n2; i++) {
            if (isEven.test(command)) {

            }
        }
        return listForAppends;
    }

}
