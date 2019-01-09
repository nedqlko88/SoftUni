package com.ned.demo.services;


import com.ned.demo.entities.Student;
import com.ned.demo.models.binding.CreateStudentBindingModel;
import com.ned.demo.repositories.StudentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, ModelMapper modelMapper) {
        this.studentRepository = studentRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean create(CreateStudentBindingModel createStudentBindingModel) {
        Student student = this.modelMapper.map(createStudentBindingModel, Student.class);
//this.studentRepository.save(student) - returns the object saved in the DB (if it is saved, otherwise it will returns null)
        return this.studentRepository.save(student) != null;
    }

    @Override
    public Set<Student> getAll() {
        return this.studentRepository
                .findAll()
                .stream()
                .collect(Collectors.toUnmodifiableSet());
    }
}
