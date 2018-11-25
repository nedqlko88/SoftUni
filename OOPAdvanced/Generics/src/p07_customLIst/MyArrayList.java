package p07_customLIst;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {

    private List<T> elements;

    public MyArrayList() {
        this.elements = new ArrayList<>();
    }

    private boolean isValidIndex(int index) {
        return index >= 0 && index < elements.size();
    }

    @Override
    public void add(T element) {
        this.elements.add(element);
    }

    @Override
    public T remove(int index) {
        if (this.isValidIndex(index)) {
            return this.elements.remove(index);
        }
        return null;
    }

    @Override
    public boolean contains(T element) {
        return this.elements.contains(element);
    }

    @Override
    public void swap(int firstIndex, int secondIndex) {
        if (this.isValidIndex(firstIndex) && this.isValidIndex(secondIndex)) {
            T temp = elements.get(firstIndex);
            elements.set(firstIndex, elements.get(secondIndex));
            elements.set(secondIndex, temp);
        }

    }

    @Override
    public int countGreaterThan(T element) {
        return this.elements.stream()
                .filter(e -> e.compareTo(element) > 0)
                .toArray().length;
    }

    @Override
    public T getMax() {
        return Collections.max(this.elements);
    }

    @Override
    public T getMin() {
        return Collections.min(this.elements);
    }

   @Override
    public Iterable<T> getElements() {
        return this.elements;
    }
}
