import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p05BombNumbers {
    public static void main(String[] args) throws IOException {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> nums = Arrays.stream(reader.readLine().split(" "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        int[] commands = Arrays.stream(reader.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int bombNumber = commands[0];
        int range = commands[1];
        int bombIndex = nums.indexOf(bombNumber);

        while (bombIndex != -1) {
            int leftIndex = bombIndex - range;
            int rightIndex = bombIndex + range;
            if (leftIndex < 0) {
                leftIndex = 0;
            }
            if (rightIndex > nums.size() - 1) {
                rightIndex = nums.size() - 1;
            }
            nums.subList(leftIndex, rightIndex + 1).clear();
            bombIndex = nums.indexOf(bombNumber);
        }
        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println(sum);
    }
}
