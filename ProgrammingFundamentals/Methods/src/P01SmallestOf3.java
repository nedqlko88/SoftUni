import java.util.Scanner;

public class P01SmallestOf3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] inputNumbers = new int[3];

        for (int i = 0; i < 3; i++) {
            int n = Integer.parseInt(scanner.nextLine());
            
            inputNumbers[i] = n;
        }

        int smallestNumber = takeSmallest(inputNumbers);

        System.out.println(smallestNumber);

    }

    private static int takeSmallest(int[] inputNumbers) {
        int smallest = Integer.MAX_VALUE;

        for (int inputNumber : inputNumbers) {
            if (inputNumber <= smallest) {
                smallest = inputNumber;
            }
        }
        return smallest;
    }

}
