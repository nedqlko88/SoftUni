import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p04ListOperations {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> list = Arrays.stream(reader.readLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        String line;

        while (!"End".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            String command = commands[0];
            int element;
            int index;
            switch (command) {
                case "Add":
                    element = Integer.parseInt(commands[1]);
                    list.add(element);
                    break;
                case "Insert":
                    element = Integer.parseInt(commands[1]);
                    index = Integer.parseInt(commands[2]);
                    if (index >= 0 && index < list.size()) {
                    list.add(index, element);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Remove":
                    index = Integer.parseInt(commands[1]);
                    if (index >= 0 && index < list.size()) {
                        list.remove(index);
                    } else {
                        System.out.println("Invalid index");
                    }
                    break;
                case "Shift":
                    String side = commands[1];
                    int count = Integer.parseInt(commands[2]);
                    if ("left".equals(side)) {
                        for (int i = 0; i < count % list.size(); i++) {
                        int firstNumber = list.get(0);
                        list.remove(0);
                        list.add(firstNumber);
                        }
                    } else {
                        for (int i = 0; i <  count % list.size(); i++) {

                        int lastNumber = list.get(list.size() - 1);
                        list.remove(list.size() - 1);
                        list.add(0, lastNumber);
                        }
                    }
                    break;

            }
        }
        for (Integer i : list) {
        System.out.printf("%d ", i);
        }
    }
}
