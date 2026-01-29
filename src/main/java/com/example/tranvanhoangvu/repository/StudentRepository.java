package com.example.tranvanhoangvu.repository;

import com.example.tranvanhoangvu.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
