package p03_employee_info;

import p03_employee_info.contracts.Employee;

public class EmployeeImpl implements Employee {

    private String name;
    private int salary;

    public EmployeeImpl(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return this.getName() + " - " + this.getSalary();
    }
}
