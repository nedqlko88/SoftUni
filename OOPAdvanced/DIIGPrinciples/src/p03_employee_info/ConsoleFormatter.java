package p03_employee_info;

public class ConsoleFormatter {

    public String format(Iterable<EmployeeImpl> employees) {
        StringBuilder sb = new StringBuilder();
        for (EmployeeImpl employeeImpl : employees) {
            sb.append(employeeImpl).append(System.lineSeparator());
        }

        return sb.toString();
    }
}
