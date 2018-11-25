import java.util.*;

public class P02SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int n = input[0];
        int m = input[1];
        Set<Integer> setN = new LinkedHashSet<>();
        Set<Integer> setM = new LinkedHashSet<>();

        for (int i = 0; i < n; i++) {
            int currNumber = Integer.parseInt(scanner.nextLine());
            setN.add(currNumber);
        }

        for (int i = 0; i < m; i++) {
            int currNumber = Integer.parseInt(scanner.nextLine());
            setM.add(currNumber);
        }

        for (Integer integer : setN) {
            if (setM.contains(integer)) {
                System.out.printf("%d ", integer);
            }
        }


    }
}
