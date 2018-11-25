import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class P01UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> set = new LinkedHashSet<>();

        for (int i = 0; i < count; i++) {
            String name = scanner.nextLine();
            if (!set.contains(name)) {
                set.add(name);
            }
        }
        for (String name : set) {
            System.out.println(name);
        }
    }
}

