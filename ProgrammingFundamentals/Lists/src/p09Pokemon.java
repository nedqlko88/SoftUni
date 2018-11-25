import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p09Pokemon {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int sum = 0;

        while (!input.isEmpty()) {
            int currTaken;
            int index = Integer.parseInt(reader.readLine());

            if (index >= 0 && index < input.size()) {
                currTaken = input.get(index);
                input.remove(index);
            } else if (index >= input.size()) {
                currTaken = input.get(input.size() - 1);
                input.set(input.size() - 1, input.get(0));
            } else {
                currTaken = input.get(0);
                input.set(0, input.get(input.size() - 1));
            }
                sum += currTaken;

                for (int i = 0; i < input.size(); i++) {
                    if (input.get(i) <= currTaken) {
                        input.set(i, input.get(i) + currTaken);
                    } else {
                        input.set(i, input.get(i) - currTaken);
                    }
                }
        }
        System.out.println(sum);
    }
}
