import javafx.css.CssParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P10ByGroup {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        Map<Integer, String> map = new TreeMap<>();
        while (!"END".equals(line = reader.readLine())) {
            String[] input  =line.split("\\s+");
            StringBuilder sb = new StringBuilder();
            sb.append(input[0]).append(" ").append(input[1]);
            int group = Integer.parseInt(input[2]);

            Person person = new Person(sb.toString(), group);
            if (map.containsKey(person.getGroup())) {
                map.put(person.getGroup(), map.get(person.getGroup()) + ", " + person.getName());
            }
            map.putIfAbsent(person.getGroup(), person.getName());
        }

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.printf("%d - %s%n", entry.getKey(), entry.getValue());
        }

    }
}

class Person {
    private String name;
    private int group;

    public Person(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }
}