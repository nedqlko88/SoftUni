import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P04ArrayRotation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split("\\s+");
        int n = Integer.parseInt(reader.readLine());

        String[] result = new String[input.length];
        for (int i = 0; i < n % input.length; i++) {
                result[result.length - 1] = input [0];
            for (int j = 0; j < input.length - 1; j++) {
                result[j] = input[j + 1];
            }

            for (int j = 0; j < input.length; j++) {
                input[j] = result[j];
            }
        }

        System.out.println(String.join(" ", input));
    }
}
