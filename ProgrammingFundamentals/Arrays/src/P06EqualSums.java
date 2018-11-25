import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P06EqualSums {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] input = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
            int index = 0;
            boolean hasEqual = false;

        for (int i = 0; i < input.length; i++) {
            int leftSum = 0;
            int rightSum = 0;

            for (int leftSide = 0; leftSide < i; leftSide++) {
                leftSum += input[leftSide];
            }
            for (int rightSide = i + 1; rightSide < input.length; rightSide++) {
                rightSum += input[rightSide];
            }
            if (rightSum == leftSum) {
                index = i;
                hasEqual = true;
            }
        }

        if (hasEqual) {
            System.out.println(index);
        } else {
            System.out.println("no");
        }
    }
}
