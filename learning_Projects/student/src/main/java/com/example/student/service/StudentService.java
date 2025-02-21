package com.example.student.service;

import java.util.List;

import com.example.student.model.Student;

public interface StudentService {

	List<Student> getAllStudents();
	
	Student saveStudent(Student student);
	
	public  Student getStudentById(Long id);
	
    public 	Student update(Student student);
	
	 public String deleteStudent(Long id);

	public 	Student findByemail(String email);

}
