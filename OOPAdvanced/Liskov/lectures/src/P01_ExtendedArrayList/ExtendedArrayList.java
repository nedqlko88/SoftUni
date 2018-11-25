package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;


public class ExtendedArrayList<T extends Comparable<T>> extends ArrayList<T> {

    public T min() {
        Iterator<T> iterator = super.iterator();
        if (iterator.hasNext()) {
            T min = iterator.next();

            while (iterator.hasNext()) {
                T currElement = iterator.next();
                if (min.compareTo(currElement) > 0) {
                    min = currElement;
                }

            }
                return min;
        }
        return null;
    }

    public T max() {
        Iterator<T> iterator = super.iterator();
        if (iterator.hasNext()) {
            T max = iterator.next();

            while (iterator.hasNext()) {
                T currElement = iterator.next();
                if (max.compareTo(currElement) < 0) {
                    max = currElement;
                }

            }
            return max;
        }
        return null;
    }



}
