package com.ned.demo.services;

import com.ned.demo.entities.Student;
import com.ned.demo.models.binding.CreateStudentBindingModel;

import java.util.Set;

public interface StudentService {
    boolean create(CreateStudentBindingModel createStudentBindingModel);

    Set<Student> getAll();
}
