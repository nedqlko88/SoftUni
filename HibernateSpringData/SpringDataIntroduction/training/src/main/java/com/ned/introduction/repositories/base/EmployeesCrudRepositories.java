package com.ned.introduction.repositories.base;

import com.ned.introduction.entitties.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeesCrudRepositories extends CrudRepository<Employee, Integer> {


}