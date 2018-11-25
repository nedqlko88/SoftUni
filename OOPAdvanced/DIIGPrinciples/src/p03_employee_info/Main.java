package p03_employee_info;

import p03_employee_info.contracts.Employee;

public class Main {

    public static void main(String[] args) {
        Employee worker= new EmployeeImpl("Ned", 12);
        ((EmployeeImpl) worker).getName();

        EmployeeInfoProvider employeeInfo = new EmployeeInfoProvider();
        ConsoleFormatter formatter = new ConsoleFormatter();

        String output = formatter.format(employeeInfo.getEmployeesByName());
        System.out.println(output);
    }
}
