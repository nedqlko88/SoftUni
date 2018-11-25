import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class BufferedStreams {
    public static void main(String[] args) {
        String resDirectory = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resources\\";
        String inputPath = resDirectory + "input.txt";
        String outputPath = resDirectory + "outputFileReader.txt";

//
//        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
//             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {
//
//            String line = reader.readLine();
//            int counter = 1;
//
//            while (line != null) {
//                if (counter % 7 == 0) {
//                    writer.println(line);
//
//                }
//                counter++;
//                line = reader.readLine();
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        // Path i rabota s nego
        Path inputPath2 = Paths.get(inputPath);
        Path outputPath2 = Paths.get(outputPath);
        try (BufferedReader reader2 = Files.newBufferedReader(inputPath2)) {
            List<String> allLines = Files.readAllLines(inputPath2);
            Files.write(outputPath2, allLines);
            Collections.sort(allLines);
//            allLines.sort((a, b) -> { return  a.compareTo(b);});
//            allLines.sort(Comparator.naturalOrder());
//            allLines.sort(String::compareTo);

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}
