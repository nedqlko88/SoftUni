import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P03ExtractFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split("\\\\");

        String allFile = tokens[tokens.length - 1];
        int index = allFile.lastIndexOf(".");
        String file = allFile.substring(0,index);
        String extension = allFile.substring(index + 1);

        System.out.println("File name: " + file);

        System.out.println("File extension: " + extension);
    }
}
