import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p01Train {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> input = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        int maxPassangers = Integer.parseInt(reader.readLine());
        String line;
        while (!"end".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            String command = commands[0];

            if ("Add".equals(command) && Integer.parseInt(commands[1]) <= maxPassangers) {
                input.add(Integer.parseInt(commands[1]));
            } else {
                for (int i=0; i < input.size(); i++) {
                    int currVagon = input.get(i);
                    int addPassangers = Integer.parseInt(command);
                    int sum = currVagon + addPassangers;
                    if (sum <= maxPassangers) {
                        input.set(i , sum);
                        break;
                    }
                }
            }


        }
            for (Integer i : input) {
                System.out.printf("%d ", i);
            }

    }
}
