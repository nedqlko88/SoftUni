import java.io.File;

public class P08FolderSize {
    public static void main(String[] args) {
        String resDir = "F:\\softUni\\JavaFundamentals\\JavaAdvanced\\Exc\\InputOutput\\resourcesExc";
        File Dir = new File(resDir);

        File[] files = Dir.listFiles();
        if (files == null) {
            return;
        }

        for (File file : files) {
            if (file.isDirectory()) {
                System.out.printf("%s size: %d", file.getName(), file.length());
            }
        }
    }
}
