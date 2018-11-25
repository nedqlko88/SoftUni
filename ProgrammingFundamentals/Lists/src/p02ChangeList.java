import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p02ChangeList {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        String line;

        while (!"end".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            String command = commands[0];
            int element = Integer.parseInt(commands[1]);

            switch (command) {
                case "Delete":
                    input = input.stream().filter(e -> e != element).collect(Collectors.toList());
                    break;

                case "Insert":
                    int index = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < input.size()) {
                    input.add(index, element);
                    }
                    break;
            }
        }

        for (Integer integer : input) {
            System.out.printf("%d ", integer);
        }

    }
}
