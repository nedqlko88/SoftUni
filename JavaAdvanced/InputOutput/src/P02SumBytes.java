import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class P02SumBytes {
    public static void main(String[] args) {
        String inputPath = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc\\input.txt";
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputPath))) {
            String line = reader.readLine();
            long result = 0;
            while (line != null) {
                long sum = 0;
                for (char c : line.toCharArray()) {
                    sum += c;
                }
                result += sum;
                line = reader.readLine();
            }
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
