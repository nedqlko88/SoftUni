package com.ned.demo.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
//@RequestMapping("/home") - default za celiq kontroler za da ne povtarqme dolu route
public class HomeController extends BaseController {
    private final ModelMapper modelMapper;

    @Autowired
    public HomeController(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.addObject("pesho", "Pecata");
        return this.view("index", modelAndView);


//        second way to do it
//        modelAndView.setViewName("index");
//        modelAndView.addObject("pesho", "Pecata");
//        return modelAndView;
    }

    @PostMapping("/")
    public String indexPost(@RequestParam String name, @RequestParam int id) {
        System.out.println(name);
        System.out.println(id);

        return "redirect:/";
    }

    @GetMapping("/test/{id}")
    public ModelAndView test(ModelAndView modelAndView, @PathVariable int id) {
        System.out.println("My id is: " + id);
        return this.redirect("/");
    }

}
