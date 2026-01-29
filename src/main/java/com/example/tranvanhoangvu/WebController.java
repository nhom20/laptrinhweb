package com.example.tranvanhoangvu;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.tranvanhoangvu.entity.Student;
import com.example.tranvanhoangvu.repository.StudentRepository;

@Controller
public class WebController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/")
    public String home(Model model) {

        List<Student> students = studentRepository.findAll();
        model.addAttribute("students", students);

        return "index";
    }
}
