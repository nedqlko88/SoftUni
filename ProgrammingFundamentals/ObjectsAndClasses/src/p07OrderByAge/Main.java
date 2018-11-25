package p07OrderByAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Person person;
        List<Person> people = new ArrayList<>();

        while (!"End".equals(line = reader.readLine())) {
            String[] tokens = line.split("\\s+");
            String name = tokens[0];
            String ID = tokens[1];
            int age = Integer.parseInt(tokens[2]);
            person = new Person(name, ID, age);
            people.add(person);

        }

        people.stream().sorted(Comparator.comparing(Person::getAge))
                .forEach(System.out::println);
    }
}
