package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long> {

}
