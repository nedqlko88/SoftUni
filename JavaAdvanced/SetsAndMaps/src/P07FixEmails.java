import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.Scanner;

public class P07FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Map<String, String> map = new LinkedHashMap<>();

        while (!"stop".equals(name)) {
            String email = scanner.nextLine();

            if (!"us".equals(email.substring(email.length() - 2)) &&
                    !"uk".equals(email.substring((email.length() - 2))) &&
                    !"com".equals(email.substring((email.length() - 3)))) {
                map.put(name, email);
            }
            name = scanner.nextLine();
        }

        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        }
    }
}
