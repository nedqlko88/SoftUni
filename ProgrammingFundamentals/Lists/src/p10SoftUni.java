import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class p10SoftUni {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> courses = Arrays.stream(reader.readLine().split(", ")).collect(Collectors.toList());
        String line;

        while (!"course start".equals(line = reader.readLine())) {
            String[] commands = line.split(":");
            String command = commands[0];
            String lessonTitle = commands[1];

            switch (command) {
                case "Add":
                    if (!courses.contains(lessonTitle)) {
                        courses.add(lessonTitle);
                    }
                    break;
                case "Insert":
                    if (!courses.contains(lessonTitle)) {
                        courses.add(Integer.parseInt(commands[2]), lessonTitle);
                    }
                    break;

                case "Remove":
                    courses.remove(lessonTitle);
                    courses.remove(lessonTitle + "-Exercise");
                    break;

                case "Swap":
                    if (courses.contains(lessonTitle) && courses.contains(commands[2])
                            && !courses.contains(lessonTitle + "-Exercise")
                            && !courses.contains(commands[2] + "-Exercise")) {

                        int index1 = courses.indexOf(lessonTitle);
                        int index2 = courses.indexOf(commands[2]);
                        String temp = courses.get(index1);
                        courses.set(index1, commands[2]);
                        courses.set(index2, temp);
                    } else if (courses.contains(lessonTitle) && courses.contains(commands[2])
                            && !courses.contains(lessonTitle + "-Exercise")
                            && courses.contains(commands[2] + "-Exercise")) {
                        int index1 = courses.indexOf(lessonTitle);
                        int index2 = courses.indexOf(commands[2]);
                        String temp = courses.get(index1);
                        courses.set(index1, commands[2]);
                        courses.set(index2, temp);
                        courses.remove(commands[2] + "-Exercise");
                        courses.add(index1 + 1, commands[2] + "-Exercise");
                    } else if (courses.contains(lessonTitle) && courses.contains(commands[2])
                            && courses.contains(lessonTitle + "-Exercise")
                            && !courses.contains(commands[2] + "-Exercise")) {
                        int index1 = courses.indexOf(lessonTitle);
                        int index2 = courses.indexOf(commands[2]);
                        String temp = courses.get(index1);
                        courses.set(index1, commands[2]);
                        courses.set(index2, temp);
                        courses.remove(lessonTitle + "-Exercise");
                        courses.add(index2 + 1, lessonTitle + "-Exercise");
                    }
                    break;

                case "Exercise":
                    if (courses.contains(lessonTitle) && (!courses.contains(lessonTitle + "-Exercise"))) {
                        int index = courses.indexOf(lessonTitle);
                        courses.add(index + 1, lessonTitle + "-Exercise");
                    }
                    if (!courses.contains(lessonTitle)) {
                        courses.add(lessonTitle);
                        courses.add(lessonTitle + "-Exercise");
                    }
                    break;
            }
        }


        for (int i = 0, count = 1; i < courses.size(); i++, count++) {
            System.out.println(String.format("%d.%s", count, courses.get(i)));
        }
    }
}
