package warning_levels;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Logger logger = new Logger(reader.readLine());

        String line;

        while (!"END".equals(line = reader.readLine())) {
            String[] cmdArgs = line.split(": ");
            logger.addMessage(cmdArgs[0], cmdArgs[1]);
        }

        for (Message message : logger.getMessages()) {
            System.out.println(message);
        }

    }
}
