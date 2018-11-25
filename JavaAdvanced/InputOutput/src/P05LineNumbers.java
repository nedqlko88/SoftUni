import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P05LineNumbers {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\";
        String inputPath = resDir + "inputLineNumbers.txt";
        String outputPath = resDir + "output.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            String line = reader.readLine();
            int numberRow = 0;
            while   (line != null) {
                if (Character.isUpperCase(line.toCharArray()[0])) {
                    numberRow++;
                    writer.printf("%s. ", numberRow);
                }
                writer.println(line);
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
