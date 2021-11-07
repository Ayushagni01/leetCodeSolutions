package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entities.Student;
import com.example.demo.repos.StudentRepository;

@SpringBootTest
class StudentPortalApplicationTests {
	
	@Autowired
	StudentRepository repo;
	
	/*
	@Test
	void testCcreateStudent() {
		Student student=new Student();
		student.setName("ayush");
		student.setCourse("Spring Boot ");
		student.setFee(30d);
		repo.save(student);
		
	}
	
	@Test
	void testfindbyId()
	{
		Student s=repo.findById(1l).get();
		System.out.println(s); 
	}
*/
	
	@Test 
	void testupdateStudent()
	{
		Student s=repo.findById(1l).get();
		s.setFee(400d);
		repo.save(s);
	}
}
