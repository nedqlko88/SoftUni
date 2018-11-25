package p07_customLIst;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        MyList<String> myList = new MyArrayList<>();
        String line;

        while (!"END".equals(line = reader.readLine())) {
            String[] commands = line.split("\\s+");
            String command = commands[0];
            int index;
            String element;
            switch (command) {
                case "Add":
                    element = commands[1];
                    myList.add(element);
                    break;
                case "Remove":
                    index = Integer.parseInt(commands[1]);
                    myList.remove(index);
                    break;
                case "Contains":
                    element = commands[1];
                    System.out.println(myList.contains(element));
                    break;
                case "Swap":
                    index = Integer.parseInt(commands[1]);
                    int secondIndex = Integer.parseInt(commands[2]);
                    myList.swap(index, secondIndex);
                    break;
                case "Greater":
                    element = commands[1];
                    System.out.println(myList.countGreaterThan(element));
                    break;
                case "Max":
                    System.out.println(myList.getMax());
                    break;
                case "Min":
                    System.out.println(myList.getMin());
                    break;
                case "Print":
                    for (String s : myList.getElements()) {
                        System.out.println(s);
                    }
                    break;


            }
        }

    }
}
