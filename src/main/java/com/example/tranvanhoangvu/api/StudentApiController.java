package com.example.tranvanhoangvu.api;

import com.example.tranvanhoangvu.entity.Student;
import com.example.tranvanhoangvu.repository.StudentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*") // ⭐ FIX CORS
@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    private final StudentRepository repo;

    public StudentApiController(StudentRepository repo) {
        this.repo = repo;
    }

    // READ ALL
    @GetMapping
    public List<Student> getAll() {
        return repo.findAll();
    }

    // CREATE
    @PostMapping
    public Student create(@RequestBody Student student) {
        return repo.save(student);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student student) {
        Student s = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        s.setName(student.getName());
        s.setAge(student.getAge());
        return repo.save(s);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }
}
