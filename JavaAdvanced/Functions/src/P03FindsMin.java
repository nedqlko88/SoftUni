import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.function.Function;

public class P03FindsMin {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        Function<int[], Integer> findMin = arr -> {
            int bestMin = Integer.MAX_VALUE;
            for (int num : arr) {
                if (num < bestMin) {
                    bestMin = num;
                }
            }
            return bestMin;
        };

        int min = findMin.apply(input);

        System.out.println(min);
    }
}
