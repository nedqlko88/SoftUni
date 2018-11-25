import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class P04CountCharacters {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\";
        String inputPath = resDir + "input.txt";
        String outputPath = resDir + "output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = reader.readLine();
            int vowels = 0;
            int consonants = 0;
            int punctuation = 0;
            List<Character> punctuationList = new ArrayList<>();
            Collections.addAll(punctuationList, '.', ',', '?', '!');
            List<Character> vowelsList = new ArrayList<>();
            Collections.addAll(vowelsList, 'a', 'e', 'i', 'o', 'u');

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (c != 32) {
                        if (punctuationList.contains(c)) {
                            punctuation++;
                        } else if (vowelsList.contains(c)) {
                            vowels++;
                        } else {
                            consonants++;
                        }
                    }
                }
                line = reader.readLine();
            }
            writer.printf("Vowels: %d%n", vowels);
            writer.printf("Consonants: %d%n", consonants);
            writer.printf("Punctuation: %d%n", punctuation);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
