import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class P05SoftUniParking {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Map<String, String> users = new LinkedHashMap<>();
        int n = Integer.parseInt(reader.readLine());

        while (n-- > 0) {
            String[] cmdArgs = reader.readLine().split("\\s+");
            String command = cmdArgs[0];
            String name = cmdArgs[1];

            switch (command) {
                case "register":
                    String regNumber = cmdArgs[2];
                    if (users.containsKey(name)) {
                        System.out.println(String.format("ERROR: already registered with plate number %s", users.get(name)));
                    } else {
                    users.put(name, regNumber);
                        System.out.println(String.format("%s registered %s successfully", name, regNumber));
                    }

                    break;
                case "unregister":
                    if (users.containsKey(name)) {
                        users.remove(name);
                        System.out.println(String.format("%s unregistered successfully", name));
                    } else {
                        System.out.println(String.format("ERROR: user %s not found", name));
                    }
                    break;
            }

        }
            for (Map.Entry<String, String> entry : users.entrySet()) {
                System.out.println(String.format("%s => %s", entry.getKey(), entry.getValue()));
            }

    }
}
