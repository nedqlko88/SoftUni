package p03_employee_info;

import p03_employee_info.contracts.InfoProvider;

import java.util.List;
import java.util.stream.Collectors;

public class EmployeeInfoProvider implements InfoProvider {

    private EmployeeDatabase database;

    public EmployeeInfoProvider() {
        this.database = new EmployeeDatabase();
    }

    @Override
    public List<EmployeeImpl> getEmployeesByName() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> e1.getName().compareTo(e2.getName()))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeImpl> getEmployeesBySalary() {
        return this.database.readEmployees().stream()
                .sorted((e1, e2) -> Integer.compare(e2.getSalary(), e1.getSalary()))
                .collect(Collectors.toList());
    }
}
