import java.io.*;
import java.util.Scanner;

public class CharacterStream {
    public static void main(String[] args) {
        String resDirectory = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resources\\";
        String inputPath = resDirectory + "input.txt";
        String outputPath = resDirectory + "outputFileReader.txt";


        try (Scanner scanner = new Scanner(new FileInputStream(inputPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))) {

            while (scanner.hasNext()) {
                if (scanner.hasNextInt()) {
                    writer.println(scanner.nextInt());
                }
                scanner.next();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
