import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P04SortStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input;
        List<Students> students = new ArrayList<>();

        while (!"END".equals(input = reader.readLine())) {
            String[] names = input.split("\\s+");
            String firstName = names[0];
            String lastName = names[1];

            Students student = new Students(firstName, lastName);
            students.add(student);
        }

        students.stream()
                .sorted((s1,s2) -> {
                    int comparingLastNames = s1.getLastName().compareTo(s2.getLastName());

                    if (comparingLastNames != 0) {
                        return comparingLastNames;
                    }

                    return s2.getFirstName().compareTo(s1.getFirstName());
                })
                .forEach(System.out::println);



    }
}

class Students {
    private String firstName;
    private String lastName;

    public Students(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}


