import java.io.BufferedReader;
        import java.io.IOException;
        import java.io.InputStreamReader;
        import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collections;
        import java.util.List;
        import java.util.stream.Collectors;

public class p07AppendArrays {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> input = Arrays.stream(reader.readLine().split("\\s*\\|\\s*"))
                .collect(Collectors.toList());
        List<String> result = new ArrayList<>();



        Collections.reverse(input);

        for (String s : input) {
            String[] littleArray = s.split("\\s+");
            result.addAll(Arrays.asList(littleArray));
        }
        result = result.stream().filter(a -> !a.isEmpty()).collect(Collectors.toList());
        System.out.println(String.join(" ", result));
    }

}
