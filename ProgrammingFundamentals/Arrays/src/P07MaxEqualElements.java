import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P07MaxEqualElements {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bestNumber = input[0];
        int bestLen = 1;
        int currlen = 1;
        int currStart = 0;

        for (int i = 1; i < input.length; i++) {
            if (input[i] == input[i - 1]) {
                currlen++;
                currStart = input[i-1];
                if (currlen > bestLen) {
                    bestLen = currlen;
                    bestNumber = currStart;
                }
            } else {
                currlen = 1;
            }

        }
        for (int i = 0; i < bestLen; i++) {
            System.out.printf("%d ",bestNumber);
        }
    }
}
