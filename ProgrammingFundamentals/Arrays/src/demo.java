import java.util.Arrays;
import java.util.Scanner;

public class demo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] currDNA = Arrays.stream(scanner.nextLine().split("[!]+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int bestSeq = 1;
        int currSeq = 0;
        int currIndex;
        int bestIndex = currDNA.length - 1;

        for (int i = currDNA.length - 1; i >= 0 ; i--) {
            if (currDNA[i] == 1) {
                currSeq++;
                currIndex = i;
                if (currSeq >= bestSeq) {
                    bestSeq = currSeq;
                    bestIndex = currIndex;
                }
            } else {
                currSeq = 0;
            }
        }

        System.out.println(bestSeq);
        System.out.println(bestIndex);
    }
}
