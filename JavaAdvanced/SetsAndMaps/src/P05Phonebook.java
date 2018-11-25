import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class P05Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> phonebook = new HashMap<>();
        String[] input = scanner.nextLine().split("-");

        while (!"search".equals(input[0])) {
            phonebook.put(input[0], input[1]);
            input = scanner.nextLine().split("-");
        }

        String searchedName = scanner.nextLine();

        while (!"stop".equals(searchedName)) {
            if (phonebook.containsKey(searchedName)) {
                System.out.printf("%s -> %s%n", searchedName, phonebook.get(searchedName));
            } else {
                System.out.printf("Contact %s does not exist.%n", searchedName);
            }

            searchedName = scanner.nextLine();
        }
    }
}
