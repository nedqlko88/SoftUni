package productshop.utils;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.util.Scanner;

public class ResourceFileReaderImpl implements ResourceFileReader {

    @Override
    public String readFile(String fileName) throws IOException {
        File file = new ClassPathResource(fileName).getFile();
        StringBuilder sb = new StringBuilder();
        Scanner reader = new Scanner(new FileReader(file));

        while (reader.hasNext()) {
            sb.append(reader.nextLine());
        }
        return sb.toString();
//        File file = new File(filePath);
//        BufferedReader reader =
//                new BufferedReader(
//                        new InputStreamReader(
//                                new FileInputStream(file)
//                        )
//                );
//        StringBuilder sb = new StringBuilder();
//        String line;
//
//        while ((line = reader.readLine()) != null) {
//            sb.append(line);
//        }
//        return sb.toString();
    }
}
