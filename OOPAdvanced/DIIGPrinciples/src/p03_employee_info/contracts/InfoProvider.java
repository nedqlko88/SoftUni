package p03_employee_info.contracts;

import p03_employee_info.EmployeeImpl;

import java.util.List;

public interface InfoProvider {

    List<EmployeeImpl> getEmployeesByName();

    List<EmployeeImpl> getEmployeesBySalary();
}
