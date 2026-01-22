package com.example.tranvanhoangvu;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(Model model) {

        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nguyễn Văn A", 20));
        students.add(new Student(2, "Nguyễn Văn B", 21));
        students.add(new Student(3, "Nguyễn Văn C", 22));

        model.addAttribute("students", students);
        return "index";
    }

    // dùng lại model
    static class Student {
        private int id;
        private String name;
        private int age;

        public Student(int id, String name, int age) {
            this.id = id;
            this.name = name;
            this.age = age;
        }
        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
    }
}
