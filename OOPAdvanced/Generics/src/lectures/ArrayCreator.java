import java.lang.reflect.Array;

public class ArrayCreator<T> {


    public static <T> T[] create(int lenght, T item) {
        //noinspection unchecked
        T[] arr = (T[]) new Object[lenght];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }

    public static <T> T[] create(Class<T> cl, int lenght, T item) {
        //noinspection unchecked
        T[] arr = (T[]) Array.newInstance(cl, lenght);
        for (int i = 0; i < arr.length; i++) {
            arr[i] = item;
        }
        return arr;
    }
}
