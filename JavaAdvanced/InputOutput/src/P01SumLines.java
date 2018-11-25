import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P01SumLines {
    public static void main(String[] args) {
        String inputPath = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\input.txt";

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            String line = reader.readLine();

            while (line != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    System.out.printf("%s", c);
//                    System.out.printf("%d", (int)c);
                    sum += c;
                }
                System.out.println();
                System.out.println(sum);
                line = reader.readLine();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
