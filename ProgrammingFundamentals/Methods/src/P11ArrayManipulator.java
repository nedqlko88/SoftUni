import java.util.Arrays;
import java.util.Scanner;

public class P11ArrayManipulator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        String tokens;
        if (input.length == 0) {
            return;
        }

        while (!"end".equals(tokens = scanner.nextLine())) {
            String[] commands = tokens.split("\\s+");
            String command = commands[0];
            String second = commands[1];
            switch (command) {
                case "exchange":
                    exchangeArray(input, second);
                    break;
                case "max":
                    int maxIndex = findMax(input, second);
                    if (maxIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(maxIndex);
                    }
                    break;
                case "min":
                    int minIndex = findMin(input, second);
                    if (minIndex == -1) {
                        System.out.println("No matches");
                    } else {
                        System.out.println(minIndex);
                    }
                    break;
                case "first":
                    int count = Integer.parseInt(second);
                    String type = commands[2];
                    findFirst(input, count, type);
                    break;
                case "last":
                    int count1 = Integer.parseInt(second);
                    String type1 = commands[2];
                    findLast(input, count1, type1);
                    break;
            }
        }

        System.out.println(Arrays.toString(input));
    }

    private static void findLast(int[] input, int count1, String type1) {
        boolean findEven = true;
        int counter = 0;
        if ("odd".equals(type1)) {
            findEven = false;
        }

        int[] result = new int[input.length];
        if (count1 > input.length || count1 < 0) {
            System.out.println("Invalid count");
        } else {
            for (int i = input.length - 1; i >= 0; i--) {
                if (input[i] != 0 && findEven && input[i] % 2 == 0) {
                    result[counter] = input[i];
                    counter++;
                    if (counter == count1) {
                        break;
                    }
                } else if (input[i] != 0 && !findEven && input[i] % 2 != 0) {
                    result[counter] = input[i];
                    counter++;
                    if (counter == count1) {
                        break;
                    }
                }
            }
            result =  Arrays.stream(result).filter(a -> a != 0).toArray();
            for (int i = 0; i < result.length / 2; i++) {
                int temp;
                temp = result[i];
                result[i] = result[result.length - 1 - i];
                result[result.length - 1 - i] = temp;
            }
            System.out.println(Arrays.toString(result));
        }
    }

    private static void findFirst(int[] input, int count, String type) {
        boolean findEven = true;
        int counter = 0;
        if ("odd".equals(type)) {
            findEven = false;
        }

        int[] result = new int[input.length];
        if (count > input.length || count < 0) {
            System.out.println("Invalid count");
        } else {
            for (int i = 0; i < input.length; i++) {
                if (input[i] != 0 && findEven && input[i] % 2 == 0) {
                    result[counter] = input[i];
                    counter++;
                    if (counter == count) {
                        break;
                    }
                } else if (input[i] != 0 && !findEven && input[i] % 2 != 0) {
                    result[counter] = input[i];
                    counter++;
                    if (counter == count) {
                        break;
                    }
                }
            }
            result =  Arrays.stream(result).filter(a -> a != 0).toArray();
            System.out.println(Arrays.toString(result));
        }
    }

    private static int findMin(int[] input, String second) {
        int min = -1;
        int currMin = Integer.MAX_VALUE;

        for (int i = 0; i < input.length; i++) {
            switch (second) {
                case "even":
                    if (input[i] != 0 && input[i] % 2 == 0 && input[i] <= currMin) {
                        currMin = input[i];
                        min = i;
                    }
                    break;
                case "odd":
                    if (input[i] != 0 && input[i] % 2 != 0 && input[i] <= currMin) {
                        currMin = input[i];
                        min = i;
                    }
                    break;
            }
        }
        return min;
    }

    private static int findMax(int[] input, String second) {
        int max = -1;
        int currMax = Integer.MIN_VALUE;

        for (int i = 0; i < input.length; i++) {
            switch (second) {
                case "even":
                    if (input[i] != 0 && input[i] % 2 == 0 && input[i] >= currMax) {
                        currMax = input[i];
                        max = i;
                    }
                    break;
                case "odd":
                    if (input[i] != 0 && input[i] % 2 != 0 && input[i] >= currMax) {
                        currMax = input[i];
                        max = i;
                    }
                    break;
            }
        }

        return max;
    }

    private static void exchangeArray(int[] input, String second) {
        int[] manArray = new int[input.length];
        int index = Integer.parseInt(second);
        if (index < 0 || index >= input.length) {
            System.out.println("Invalid index");
        } else {
            int count = 0;
            for (int i = index + 1; i < input.length; i++, count++) {
                manArray[count] = input[i];
            }
            for (int i = 0; i < index + 1; i++, count++) {
                manArray[count] = input[i];
            }
            for (int i = 0; i < input.length; i++) {
                input[i] = manArray[i];
            }
        }
    }
}
