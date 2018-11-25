import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P09Enrolled20142015 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        List<Fermers> fermers = new ArrayList<>();


        while (!"END".equals(line = reader.readLine())) {
            String[] input = line.split("\\s+");
            String facNumber = input[0];
            List<Integer> marks = new ArrayList<>();
            for (int i = 1; i < input.length; i++) {
                marks.add(Integer.parseInt(input[i]));
            }

            Fermers fermer = new Fermers(facNumber, marks);
            fermers.add(fermer);
        }

        fermers.stream()
                .filter(f -> f.getFacNumber().endsWith("14") || f.getFacNumber().endsWith("15"))
                .forEach(System.out::println);
    }
}


class Fermers {
    private String facNumber;
    private List<Integer> marks;

    public Fermers(String facNumber, List<Integer> marks) {
        this.facNumber = facNumber;
        this.marks = marks;
    }

    public String getFacNumber() {
        return facNumber;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
            for (Integer integer : marks) {
                sb.append(integer).append(" ");
            }
        return sb.toString();
    }
}

