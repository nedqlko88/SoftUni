import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.regex.Matcher;

public class P10LadyBugs {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n];
        int[] bugsIndexes = Arrays.stream(reader.readLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String input;

        for (int bugsIndex : bugsIndexes) {
            if (bugsIndex >= 0 && bugsIndex < n) {
                array[bugsIndex] = 1;
            }
        }


        while (!"end".equals(input = reader.readLine())) {
            String[] commands = input.split("\\s+");
            int fromIndex = Integer.parseInt(commands[0]);
            int flyLenght = Integer.parseInt(commands[2]);
            String direction = commands[1];

            if (flyLenght < 0 && "right".equals(direction)) {
                direction = "left";
                flyLenght = Math.abs(flyLenght);
            }
            if (flyLenght < 0 && "left".equals(direction)) {
                direction = "right";
                flyLenght = Math.abs(flyLenght);
            }
            if (fromIndex < 0 || fromIndex >= n) {
                continue;
            }

            switch (direction) {
                case "right":
                    int toIndex = fromIndex + flyLenght;
                    if (toIndex >= 0 && toIndex < n) {
                        if (array[fromIndex] != 0 && array[toIndex] == 0) {
                            array[fromIndex] = 0;
                            array[toIndex] = 1;
                        } else if (array[fromIndex] != 0 && array[toIndex] == 1) {
                            array[fromIndex] = 0;
                            for (int i = toIndex; i < n; i += flyLenght) {
                                if (array[i] == 0) {
                                    array[i] = 1;
                                    break;
                                }
                            }
                        }
                    } else {
                        array[fromIndex] = 0;
                    }
                    break;

                case "left":
                    toIndex = fromIndex - flyLenght;
                    if (toIndex >= 0 && toIndex < n) {
                        if (array[fromIndex] != 0 && array[toIndex] == 0) {
                            array[fromIndex] = 0;
                            array[toIndex] = 1;
                        } else if (array[fromIndex] != 0 && array[toIndex] == 1) {
                            array[fromIndex] = 0;
                            for (int i = toIndex; i >= 0; i -= flyLenght) {
                                if (array[i] == 0) {
                                    array[i] = 1;
                                    break;
                                }
                            }
                        } else {
                            array[fromIndex] = 0;
                        }
                    } else {
                        array[fromIndex] = 0;
                    }
                    break;
            }
        }

        for (int i : array) {
            System.out.printf("%d ", i);
        }
    }
}
