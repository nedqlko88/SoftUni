import java.util.ArrayList;
import java.util.List;

public class Main1 {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList<>() {{
            add(5);
            add(2);
            add(1);
            add(2);
            add(9);

        }};
        System.out.println(ListUtils.getMin(list));
    }
}
