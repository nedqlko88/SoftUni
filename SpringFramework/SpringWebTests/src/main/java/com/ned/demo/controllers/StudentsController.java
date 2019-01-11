package com.ned.demo.controllers;

import com.ned.demo.models.binding.CreateStudentBindingModel;
import com.ned.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/students")
public class StudentsController extends BaseController {
    private final StudentService studentService;


    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public ModelAndView createStudent(CreateStudentBindingModel createStudentBindingModel) {
        this.studentService.create(createStudentBindingModel);

        return this.redirect("all");
    }

    @GetMapping(value = "/all", produces = "application/json")
    @ResponseBody
    public Object allStudents() {
        return this.studentService.getAll();
    }
}
