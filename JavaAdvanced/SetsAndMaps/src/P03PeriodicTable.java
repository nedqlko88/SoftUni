import java.util.HashSet;
        import java.util.Scanner;
        import java.util.Set;
        import java.util.TreeSet;

public class P03PeriodicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> set = new TreeSet<>();

        for (int i = 0; i < count; i++) {
            String[] currElement = scanner.nextLine().split("\\s+");
            for (String s : currElement) {
                set.add(s);
            }
        }

        for (String s : set) {
            System.out.printf("%s ",s);
        }
    }
}
