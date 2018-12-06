package com.ned.introduction;

import com.ned.introduction.entitties.Employee;
import com.ned.introduction.repositories.base.EmployeesCrudRepositories;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IntroductionApplication {

    public IntroductionApplication(EmployeesCrudRepositories employeesRepository) {
        Iterable<Employee> employees = employeesRepository.findAll();

//        for (Employee employee : employees) {
//            System.out.println(employee.getFirstName());
//        }

        Employee emp = new Employee();
        emp.setFirstName("Vanq");
        emp.setLastName("Petrova");
        employeesRepository.save(emp);


//        employeesRepository.
//                findById(1).
//                ifPresent(
//                        employee -> System.out.println(employee.getFirstName())
//                );

    }

    public static void main(String[] args) {
        SpringApplication.run(IntroductionApplication.class, args);
    }
}
