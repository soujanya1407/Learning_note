package com.example.student.service.impl;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.student.model.Student;
import com.example.student.repository.StudentReopository;
import com.example.student.service.StudentService;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl  implements StudentService{

	
	@Autowired
	StudentReopository  studentReopository;


	public StudentServiceImpl(StudentReopository studentRepository) {
		super();
		this.studentReopository = studentRepository;
	}


	public List<Student> getAllStudents() {
		return studentReopository.findAll();
	}

	public Student saveStudent(Student student) {
		return studentReopository.save(student);
	}

	@Override
	public Student getStudentById(Long id) {
		return studentReopository.findById(id).orElse(null);
	}

	@Override
	public Student update(Student student) {
		return studentReopository.save(student);
	}

	@Override
	public String deleteStudent(Long id) {
		studentReopository.deleteById(id);
		return null;
	}





	@Override
	public Student findByemail(String email) {
		return studentReopository.findByemail(email);
	}
}

	


	


