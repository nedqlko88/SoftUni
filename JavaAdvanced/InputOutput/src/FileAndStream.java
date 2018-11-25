import java.io.File;

public class FileAndStream {
    public static void main(String[] args) {
        String resDirectory = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resources\\";
        String rootDirectoryPath = resDirectory + "Files-and-Streams";

        File rootDir = new File(rootDirectoryPath);
        if (!rootDir.exists()) {
            return;
        }
        File[] files = rootDir.listFiles();
        if (files == null) {
            return;
        }

//            for (File file : files) {
//                if (!file.isDirectory()) {
//                    System.out.printf("%s: [%s in bytes]%n", file.getName(), file.length());
//                }
//            }

        int counter = 1;

        while (true) {

        }

    }
}

