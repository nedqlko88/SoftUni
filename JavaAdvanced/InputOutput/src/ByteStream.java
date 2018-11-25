import java.io.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ByteStream {
    public static void main(String[] args) {
        String resDirectory = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resources\\";
        String inputPath = resDirectory + "input.txt";
        String outputPath = resDirectory + "output.txt";

        Set<Character> punctuation = new HashSet<>();
        Collections.addAll(punctuation, '.', ',', '!', '?');

        try (InputStream fis = new FileInputStream(inputPath);
             OutputStream fos = new FileOutputStream(outputPath)) {
            int oneByte = fis.read();


            while (oneByte >= 0) {
                oneByte = fis.read();

                if (!punctuation.contains((char) oneByte)) {
                    fos.write(oneByte);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
