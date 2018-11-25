package P04_DetailPrinter;

import javax.swing.event.DocumentEvent;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Employee emp = new Employee("Pesho");
        Developer developer = new Developer("Devcho", "project");
        Manager manager = new Manager("Ned", Arrays.asList("sds", "fsfsfs", "fsfsfs"));

        DetailsPrinter dp = new DetailsPrinter(Arrays.asList(emp,developer,manager));

        dp.printDetails();
    }
}
