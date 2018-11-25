import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P09KaminoFactory {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] bestDNA = new int[n];
        int bestSeq = 0;
        int bestLeftIndex = n - 1;
        int bestSum = 0;
        int bestLine = 0;
        String input;
        int currLine = 0;

        while (!"Clone them!".equals(input = reader.readLine())) {
            int[] currDNA = Arrays.stream(input.split("[!]+"))
                    .mapToInt(Integer::parseInt)
                    .toArray();

            currLine++;
            int[] currLongestLeft = findLongestLeft(currDNA);
            int currSeq = currLongestLeft[0];
            int currLeftIndex = currLongestLeft[1];
            int currSum = Arrays.stream(currDNA).sum();

            if (currSeq > bestSeq) {
                bestSeq = currSeq;
                bestLeftIndex = currLeftIndex;
                bestSum = currSum;
                bestLine = currLine;
                for (int i = 0; i < bestDNA.length; i++) {
                    bestDNA[i] = currDNA[i];
                }
            } else if (currSeq == bestSeq) {
                if (currLeftIndex < bestLeftIndex) {
                    bestSeq = currSeq;
                    bestLeftIndex = currLeftIndex;
                    bestSum = currSum;
                    bestLine = currLine;
                    for (int i = 0; i < bestDNA.length; i++) {
                        bestDNA[i] = currDNA[i];
                    }
                } else if (currLeftIndex == bestLeftIndex) {
                    if (currSum > bestSum) {
                        bestSeq = currSeq;
                        bestLeftIndex = currLeftIndex;
                        bestSum = currSum;
                        bestLine = currLine;
                        for (int i = 0; i < bestDNA.length; i++) {
                            bestDNA[i] = currDNA[i];
                        }
                    } else if (currLine == 1) {
                        bestSeq = currSeq;
                        bestLeftIndex = currLeftIndex;
                        bestSum = currSum;
                        bestLine = currLine;
                        for (int i = 0; i < bestDNA.length; i++) {
                            bestDNA[i] = currDNA[i];
                        }
                    }
                }
            }
        }

        System.out.printf("Best DNA sample %d with sum: %d.%n", bestLine, bestSum);
        for (int i : bestDNA) {
            System.out.printf("%d ", i);
        }
//        System.out.println(bestSum);
//        System.out.println(bestLeftIndex);
//        System.out.println(bestSeq);
//        System.out.println(bestLine);
    }

    private static int[] findLongestLeft(int[] currDNA) {
        int bestSeq = 0;
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

        int[] result;
        result = new int[]{bestSeq, bestIndex};
        return result;
    }
}
