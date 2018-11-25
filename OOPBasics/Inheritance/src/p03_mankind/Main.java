package p03_mankind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputStudent = reader.readLine().split("\\s+");
        String[] inputWorker = reader.readLine().split("\\s+");

        try {
            Human student = new Student(inputStudent[0], inputStudent[1], inputStudent[2]);
            Human worker = new Worker(inputWorker[0], inputWorker[1],
                    Double.parseDouble(inputWorker[2]),
                    Double.parseDouble(inputWorker[3]));
            System.out.println(student);
            System.out.println(worker);
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
