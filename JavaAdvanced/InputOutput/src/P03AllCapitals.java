import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P03AllCapitals {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\";
        String inputPath = resDir + "input.txt";
        String outputPath = resDir + "output.txt";


        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath));
             PrintWriter write = new PrintWriter(new FileOutputStream(outputPath))) {
            String line = reader.readLine();

            while (line != null) {
                for (char c : line.toCharArray()) {
                    if (Character.isLowerCase(c)) {
                        c = Character.toUpperCase(c);
                    }
                    write.printf("%s", c);
                }
                write.println();
                line = reader.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
