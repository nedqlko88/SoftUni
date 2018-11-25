package P04_DetailPrinter;

public class DetailsPrinter {

    private Iterable<Employee> employees;

    public DetailsPrinter(Iterable<Employee> employees)
    {
        this.employees = employees;
    }

    public void printDetails() {
        for (Employee employee : employees) {
            printEmployee(employee);
        }
    }

    private void printEmployee(Employee emp) {
        System.out.println(emp);
    }

}
