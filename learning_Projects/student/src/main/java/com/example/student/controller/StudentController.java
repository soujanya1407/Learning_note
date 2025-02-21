package com.example.student.controller;

import java.util.List;

import com.example.student.service.StudentService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.student.model.Student;


@RestController
public class StudentController {
	
	@Autowired
	StudentService studentService;
	
	
	//public StudentController(StudentService studentService) {
		//super();
		//this.studentService = studentService;
	//}
	

	@PostMapping("/saveStudent")
	public Student listStudents(@RequestBody Student student) {
		System.out.println(student.getFirstName());
		return studentService.saveStudent(student);
	}
	
	@GetMapping("/getAllStudent")
	public List<Student> listStudentt1(Student student) {
		return  studentService.getAllStudents();
	}

	@GetMapping("/getStudent/{id}")
	public Student getStudent(@PathVariable Long id)
	{
		return studentService.getStudentById(id);
	}

	@PutMapping("/update")
	public String updateStudent(@RequestBody Student student){
		Boolean s=false;
		try
		{
			studentService.findByemail(student.getEmail());
		}
		catch(DataAccessException e)
		{
			s=true;
		}
		if(s==false) {
			studentService.update(student);
			return "Updated";
		}
		else
			return "Error";

	}

	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable Long id){
		Boolean s=false;

			if(studentService.getStudentById(id)==null){
			//studentReopository.findById(id).get();
			s=true;
		}

		if(!s) {
			studentService.deleteStudent(id);
			return "Deleted";

		}
		else
			return "Not Found";
	}
	
}
