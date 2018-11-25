import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P06ByPhone {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Animals> animals = new ArrayList<>();

        while (!"END".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            String phone = input[2];

            Animals animal = new Animals(firstName, lastName, phone);
            animals.add(animal);
        }

        animals.stream()
                .filter(a -> {
                    if (a.getPhone().startsWith("02") || a.getPhone().startsWith("+3592")) {
                        return true;
                    }
                    return false;
                }).forEach(System.out::println);

    }
}

class Animals {
    private String firstName;
    private String lastName;
    private String phone;

    public Animals(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}