import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P05byEmail {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Clients> clients = new ArrayList<>();

        while (!"END".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            String firstName = input[0];
            String lastName = input[1];
            String email = input[2];

            Clients client = new Clients(firstName, lastName, email);

            clients.add(client);
        }

        clients.stream()
                .filter(c -> c.getEmail().contains("@gmail.com"))
                .forEach(System.out::println);

    }
}

class Clients {
    private String firstName;
    private String lastName;
    private String email;

    public Clients(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return String.format("%s %s", this.firstName, this.lastName);
    }
}
