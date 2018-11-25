import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class p03HouseParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<String> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] commands = reader.readLine().split("\\s+");
            if (commands.length == 3) {
                if (list.contains(commands[0])) {
                    System.out.printf("%s is already in the list!%n", commands[0]);
                } else {
                    list.add(commands[0]);
                }
            } else {
                if (list.contains(commands[0])) {
                    list.remove(commands[0]);
                } else {
                    System.out.printf("%s is not in the list!", commands[0]);
                }
            }
        }

        for (String s : list) {
            System.out.println(s);
        }
    }
}
