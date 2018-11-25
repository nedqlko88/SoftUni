import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P05TopIntegers {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        for (int i = 0; i < input.length - 1; i++) {
            if (isBigger(input, i)) {
                System.out.printf("%d ", input[i]);
            }
        }
        System.out.printf("%d", input[input.length -1]);
    }

    private static boolean isBigger(int[] input, int i) {
        for (int j = i + 1; j < input.length; j++) {
            if (input[i] <= input[j]) {
                return false;
            }
        }
        return true;
    }
}
