import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.function.BiPredicate;

public class P10ListOfPredicates {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] input = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        Set<Integer> divisibleNums = new TreeSet<>();
        for (int i : input) {
            divisibleNums.add(i);
        }

        List<Integer> result = new ArrayList<>();

        BiPredicate<Set<Integer>, Integer> isItDivisible = (nums, i) -> {
            for (Integer num : nums) {
                if (i % num != 0) {
                    return false;
                }
            }
            return true;
        };


        for (int i = 1; i <= n; i++) {
            if (isItDivisible.test(divisibleNums, i)) {
                result.add(i);
            }
        }

        for (Integer nums : result) {
            System.out.printf("%d ", nums);
        }


    }
}
