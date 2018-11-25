import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class p01ValidUsernames {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] tokens = reader.readLine().split(", ");

        for (String username : tokens) {
            username = username.trim();
            boolean isValid = true;
            for (int i = 0; i < username.length(); i++) {
                char currChar = username.charAt(i);
                if (!(Character.isDigit(currChar)
                        || Character.isLetter(currChar)
                        || currChar == '-'
                        || currChar == '_')) {
                    isValid = false;
                }
            }
            if (isValid && username.length() >=3
            && username.length() <= 16) {
                System.out.println(username);
            }
        }
    }
}
