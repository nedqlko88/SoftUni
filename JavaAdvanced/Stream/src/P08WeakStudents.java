import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class P08WeakStudents {
//    public static void main(String[] args) throws IOException {
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String line;
//        List<Fermers> fermers = new ArrayList<>();
//
//
//        while (!"END".equals(line = reader.readLine())) {
//            String[] input = line.split("\\s+");
//            String firstName = input[0];
//            String lastName = input[1];
//            List<Integer> marks = new ArrayList<>();
//            for (int i = 2; i < input.length; i++) {
//                marks.add(Integer.parseInt(input[i]));
//            }
//
//            Fermers fermer = new Fermers(firstName, lastName, marks);
//            fermers.add(fermer);
//        }
//
//        fermers.stream()
//                .filter(f -> {
//                    int counter = 0;
//                    for (int i = 0; i < f.getMarks().size(); i++) {
//                        if (f.getMarks().get(i) <= 3) {
//                            counter++;
//                        }
////                        int count = StringUtils.countMatches("engineering", "e");
//                    }
//                    if (counter >= 2) {
//                        return true;
//                    }
//                    return false;
//                }).forEach(System.out::println);
//    }
//}
//
//
//class Fermers {
//    private String firstName;
//    private String lastName;
//    private List<Integer> marks;
//
//    public Fermers(String firstName, String lastName, List<Integer> marks) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.marks = marks;
//    }
//
//    public List<Integer> getMarks() {
//        return marks;
//    }
//
//    @Override
//    public String toString() {
//        return String.format("%s %s", this.firstName, this.lastName);
//    }
}
