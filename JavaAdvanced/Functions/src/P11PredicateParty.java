import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class P11PredicateParty {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> names = Arrays.stream(reader.readLine().split("\\s+"))
                .collect(Collectors.toList());

        String input;

        while (!"Party!".equals(input = reader.readLine())) {
            String[] commands = input.split("\\s+");
            String command = commands[0];
            String typeSearch = commands[1];
            String valueSearch = commands[2];

            switch (command) {
                case "Double":
//                    for (int i = 0; i < names.size(); i++) {
//                        if (getPredicate(typeSearch, valueSearch).test(names.get(i))) {
//                            names.add(i, names.get(i));
//                        }
//                    } da go izprobvam kak gi dobavq i dali moeto raboti
                    List<String> dublicateNames = new ArrayList<>();
                    for (String name : names) {
                        if (getPredicate(typeSearch, valueSearch).test(name)) {
                            dublicateNames.add(name);
                        }
                        dublicateNames.add(name);
                    }
                    names = dublicateNames;
                    break;
                case "Remove":
                    names.removeIf(getPredicate(typeSearch, valueSearch));
                    break;
            }
        }
        if (names.isEmpty()) {
            System.out.println("Nobody is going to the party!");
        } else {
            System.out.printf("%s are going to the party!", String.join(", ", names));
        }
    }


    private static Predicate<String> getPredicate(String typeSearch, String valueSearch) {

        switch (typeSearch) {
            case "StartsWith":
                return name -> name.startsWith(valueSearch);
            case "EndsWith":
                return name -> name.endsWith((valueSearch));
            default:
                return name -> name.length() == Integer.parseInt(valueSearch);
        }
    }
}
