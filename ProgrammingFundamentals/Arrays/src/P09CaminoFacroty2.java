import java.util.Scanner;

public class P09CaminoFacroty2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sequenceLenght = Integer.parseInt(scanner.nextLine());
        String line;
        int bestLenght = 0;
        String bestDNA = "";
        int bestIndex = 0;
        int bestSum = 0;
        int counter = 0;
        int bestCounter = 0;

        while (!"Clone them!".equals(line = scanner.nextLine())) {
            counter++;
            String sequence = line.replaceAll("!", "");

            String[] DNAS = sequence.split("0");
            int maxLenght = 0;
            int sum = 0;
            String bestLocalDNA = "";
            for (int i = 0; i < DNAS.length; i++) {
                if (DNAS[i].length() > maxLenght) {
                    maxLenght = DNAS[i].length();
                    bestLocalDNA = DNAS[i];
                }
                sum += DNAS[i].length();
            }

            int beginIndex = sequence.indexOf(bestLocalDNA);

            if (maxLenght > bestLenght) {
                bestLenght = maxLenght;
                bestDNA = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            } else if (maxLenght == bestLenght && (beginIndex < bestIndex || sum > bestSum)) {
                bestLenght = maxLenght;
                bestDNA = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            } else if (counter == 1) {
                bestLenght = maxLenght;
                bestDNA = sequence;
                bestIndex = beginIndex;
                bestSum = sum;
                bestCounter = counter;
            }


        }
        System.out.println(String.format("Best DNA sample %d with sum: %d.", bestCounter, bestSum));
        for (int i = 0; i < bestDNA.length(); i++) {
            System.out.print(bestDNA.charAt(i) + " ");
        }
        System.out.println();
    }
}

