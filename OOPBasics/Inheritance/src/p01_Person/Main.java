package p01_Person;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        int age = Integer.parseInt(reader.readLine());
//        Person person = new Person(name, age);
//        System.out.println(person);


        try {
            Child child = new Child(name, age);
            System.out.println(child);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
//        if (child != null) {
//
//        System.out.println(String.format("Name: %s, Age: %d",child.getName(), child.getAge()));
//        }


    }

}
