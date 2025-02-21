package com.example.student;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import com.example.student.controller.StudentController;
import com.example.student.model.Student;
import com.example.student.repository.StudentReopository;
import com.example.student.service.StudentService;
import com.example.student.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class StudentApplicationTests {




	@Autowired
	StudentReopository reopository;

	@Autowired
	StudentController controller;

	@Autowired
	StudentService service;

	@BeforeEach
	void setUp() {
		//service = new Service("1","raje","cr","r@gam");

	}

	// Post method





	 @Test
	 public void post(){
		 Student student = new Student();


		 student.setId(Long.valueOf("5"));
		 student.setFirstName("Sara");
		 student.setLastName("sm");
		 student.setEmail("sm@gmail.com");


		// service.appendStudent(student, studentList);
		  List<Student> s  =  new ArrayList<>(Arrays.asList(student));


	     	 service.saveStudent(student);
		 System.out.println(student.getId());
		 System.out.println(student.getFirstName());

	  }

	 // get data by Id
	@Test
	public void get(){
		Student student = new Student();
		student = service.getStudentById(3L);


		assertThat(student.getId()!=null).isTrue();
		System.out.println(student.getId());
		System.out.println(student.getFirstName());
	}

	// Get by All
	@Test
	public void getAll(){
		Student student = new Student();
		List<Student> s  =  new ArrayList<>(Arrays.asList(student));
		s = service.getAllStudents();
		for(Student all: s)
		{
			System.out.println(all.getId());
			System.out.println(all.getFirstName());
			System.out.println(all.getLastName());
			System.out.println(all.getEmail());
		}


	}

	@Test
	public void update(){
		Student student = new Student();
		student.setId(Long.valueOf("1"));
		student.setFirstName("Rachel");
		student.setLastName("crk");
		student.setEmail("r@gmail.com");
		// service.appendStudent(student, studentList);
		List<Student> s  =  new ArrayList<>(Arrays.asList(student));

 		 Student s1 =  service.update(student);
		  System.out.println(s1.getId());
		System.out.println(s1.getFirstName());

	}


	@Test
	public void delete()
	{
		String s2 = service.deleteStudent(5L);
		System.out.println(s2);
	}



}
