package P01_ExtendedArrayList;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ExtendedArrayList<Integer> myList = new ExtendedArrayList<>();
        myList.add(1);
        myList.add(3);
        System.out.println(myList.min());
    }
}
