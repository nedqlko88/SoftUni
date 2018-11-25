package Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        Student student = null;
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] tokens = reader.readLine().split("\\s+");
            student = new Student(tokens[0], tokens[1], Double.parseDouble(tokens[2]));
            students.add(student);
        }

        students.stream()
                .sorted(Comparator.comparing(Student::getGrade).reversed())
                .forEach(System.out::println);

    }
}
