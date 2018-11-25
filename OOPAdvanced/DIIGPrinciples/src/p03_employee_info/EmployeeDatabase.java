package p03_employee_info;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDatabase {

    public List<EmployeeImpl> readEmployees() {

        List<EmployeeImpl> employeeImpls = new ArrayList<>();
        Collections.addAll(employeeImpls,
                new EmployeeImpl("Pesho", 20),
                new EmployeeImpl("Gosho", 40));

        return employeeImpls;
    }
}
