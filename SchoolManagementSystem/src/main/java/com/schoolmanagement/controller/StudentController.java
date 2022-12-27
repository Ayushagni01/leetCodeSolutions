package com.schoolmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import com.schoolmanagement.model.StudentDetails;
import com.schoolmanagement.service.StudentService;

@RestController
@RequestMapping("/student")
@CrossOrigin("*")
public class StudentController {

	
	@Autowired
	private StudentService ss;
	
	
	@GetMapping("/details/{id}")
	public StudentDetails getDetails(@PathVariable("id") Long id) {
		
		StudentDetails sd=	this.ss.getStudentDetails(id);
		return sd ;
	}
	
	
	
	//get all the students
	@GetMapping("/details/")
	public List<StudentDetails> getDetails() {
		
		ArrayList<StudentDetails> sd=	this.ss.getAllStudentDetails();
		System.out.println(sd);
		return sd ;
	}
	
	
	
	
	
	
	
	@PostMapping("/stu")
	public StudentDetails addStudent(@RequestBody StudentDetails sd)
	{
		return	this.ss.addStudentInDataBase(sd);
	}
	
	
		
	
}



//localhost:8080/student/details