import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class P06WordCount {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\";
        String wordsPath = resDir + "words.txt";
        String textPath = resDir + "text.txt";
        String outputPath = resDir + "output.txt";

        try (BufferedReader wordsReader = Files.newBufferedReader(Paths.get(wordsPath));
             BufferedReader textReader = Files.newBufferedReader(Paths.get(textPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            List<String> words = Arrays.stream(wordsReader.readLine().split("\\s+"))
                    .collect(Collectors.toList());
            List<String> text = Arrays.stream(textReader.readLine().split("\\s+"))
                    .collect(Collectors.toList());

            for (String word : words) {
                int occurrences = Collections.frequency(text, word);
                writer.printf("%s - %d%n", word, occurrences);
            }



        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}


//    int occurrences = Collections.frequency(animals, "bat");