import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.function.Consumer;

public class P02KnightsOfHonor {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        Consumer<String[]> addSir = arr -> {
            for (String name : arr) {
                System.out.println("Sir " + name);
            }
        };

        addSir.accept(input);
    }
}
