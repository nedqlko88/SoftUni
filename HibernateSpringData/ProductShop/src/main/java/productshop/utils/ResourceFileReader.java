package productshop.utils;

import java.io.IOException;

public interface ResourceFileReader {
    String readFile(String fileName) throws IOException;
}
