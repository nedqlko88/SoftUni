import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P09ForceBook {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Set<String>> sides = new LinkedHashMap<>();
        String line;

        while (!"Lumpawaroo".equals(line = reader.readLine())) {

            String[] arr = null;

            boolean isToAdd = true;

            if (line.contains("->")) {
                arr = line.split(" -> ", 2);
                isToAdd = false;
            } else {
                arr = line.split(" \\| ", 2);
            }

            if (isToAdd) {
                String side = arr[0];
                String user = arr[1];
                boolean isUnique = true;
                if (!sides.containsKey(side)) {
                    sides.put(side, new TreeSet<>());
                }
                for (Map.Entry<String, Set<String>> entry : sides.entrySet()) {
                    if (entry.getValue().contains(user)) {
                        isUnique = false;
                    }
                }
                if (isUnique) {
                sides.get(side).add(user);
                }
            } else {
                String side = arr[1];
                String user = arr[0];

                if (!sides.containsKey(side)) {
                    sides.put(side, new TreeSet<>());
                }

                if (!sides.get(side).contains(user)) {
                    for (Map.Entry<String, Set<String>> entry : sides.entrySet()) {
                        if (entry.getValue().size() > 0)
                            entry.getValue().remove(user);
                    }

                sides.get(side).add(user);
                System.out.println(String.format("%s joins the %s side!", user, side));
                }


            }
        }

        sides.entrySet().stream()
                .sorted((e1, e2) -> {
                    int com = e2.getValue().size() - e1.getValue().size();
                    if (com > 0) {
                        return 1;
                    } else if (com < 0) {
                        return -1;
                    } else {
                        return e1.getKey().compareTo(e2.getKey());
                    }
                })
                .forEach(u -> {
                    if (u.getValue().size() > 0) {
                        System.out.println(String.format("Side: %s, Members: %d", u.getKey(), u.getValue().size()));

                        u.getValue().stream().forEach(a -> System.out.println(String.format("! %s", a)));
                    }
                });
    }
}

