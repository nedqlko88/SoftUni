package p01_Box;

import p01_Box.Box;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Main2 {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        List<Box<Double>> elements = new ArrayList<>();
        while (n-- > 0) {
            Box<Double> box = new Box<>();
            Double input = Double.parseDouble(reader.readLine());
            box.setValue(input);
            elements.add(box);
        }

        Double inputToFind = Double.parseDouble(reader.readLine());
        Box<Double> elementToFind = new Box<>();
        elementToFind.setValue(inputToFind);

        int countOFGreaterElements = getCountOFGreaterElements(elements, elementToFind);
        System.out.println(countOFGreaterElements);

//        Problem 01 Generic Box
//        List<Box<String>> boxes = new ArrayList<>();
//
//        while (n-- > 0) {
//            String line = reader.readLine();
//        Box<String> box = new Box<>();
//        box.setValue(line);
//        boxes.add(box);
//        }
//        boxes.forEach(System.out::println);


//        Problem 02 Problem 2.	Generic Box of Integer
//        List<Box<Integer>> boxes = new ArrayList<>();
//
//        while (n-- > 0) {
//            String line = reader.readLine();
//        Box<Integer> box = new Box<>();
//        box.setValue(Integer.valueOf(line));
//        boxes.add(box);
//        }
//        boxes.forEach(System.out::println);


//        Problem 3.	Generic Swap Method Strings
//        List<Box<String>> boxes = new ArrayList<>();
//
//        while (n-- > 0) {
//            String line = reader.readLine();
//            Box<String> box = new Box<>();
//            box.setValue(line);
//            boxes.add(box);
//        }
//
//        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//
//        swap(boxes, indexes[0], indexes[1]);
//        boxes.forEach(System.out::println);
//
//    }
//
//    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
//        Box<T> temp = boxes.get(firstIndex);
//        boxes.set(firstIndex, boxes.get(secondIndex));
//        boxes.set(secondIndex, temp);
//    }


//        Problem 4.	Generic Swap Method Integers
//        List<Box<Integer>> boxes = new ArrayList<>();
//
//        while (n-- > 0) {
//            int line = Integer.parseInt(reader.readLine());
//            Box<Integer> box = new Box<>();
//            box.setValue(line);
//            boxes.add(box);
//        }
//
//        int[] indexes = Arrays.stream(reader.readLine().split("\\s+"))
//                .mapToInt(Integer::parseInt)
//                .toArray();
//
//
//        swap(boxes, indexes[0], indexes[1]);
//        boxes.forEach(System.out::println);
//
//    }
//
//    private static <T> void swap(List<Box<T>> boxes, int firstIndex, int secondIndex) {
//        Box<T> temp = boxes.get(firstIndex);
//        boxes.set(firstIndex, boxes.get(secondIndex));
//        boxes.set(secondIndex, temp);
//    }


    }
    public static <T extends Comparable<T>> int getCountOFGreaterElements(List<Box<T>> boxes, Box<T> element) {
return boxes.stream().filter(e -> e.compareTo(element) > 0).toArray().length;
    }
}

