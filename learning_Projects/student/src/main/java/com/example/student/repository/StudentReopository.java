package com.example.student.repository;

import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.student.model.Student;

public interface StudentReopository extends JpaRepository<Student, Long> {
    public 	Student findByemail(String email);
}
