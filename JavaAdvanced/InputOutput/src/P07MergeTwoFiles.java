import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class P07MergeTwoFiles {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\";
        String OnePath = resDir + "inputOne.txt";
        String TwoPath = resDir + "inputTwo.txt";
        String outputPath = resDir + "output.txt";
        List<String> list = new ArrayList<>();

        try (BufferedReader readerOne = Files.newBufferedReader(Paths.get(OnePath));
             BufferedReader readerTwo = Files.newBufferedReader(Paths.get(TwoPath));
             PrintWriter writer = new PrintWriter(new FileOutputStream(outputPath))){

            String line1 = readerOne.readLine();
            while (line1 != null) {
                list.add(line1);
                line1 =readerOne.readLine();
            }

            String line2 = readerTwo.readLine();

            while (line2 != null) {
                list.add(line2);
                line2 =readerTwo.readLine();
            }

            for (String s : list) {
                writer.println(s);
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
