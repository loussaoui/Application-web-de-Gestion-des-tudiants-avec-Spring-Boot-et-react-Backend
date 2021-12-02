package com.arjuncode.studentsystem.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arjuncode.studentsystem.model.Student;
import com.arjuncode.studentsystem.service.StudentService;


@CrossOrigin("*")
@RestController

@RequestMapping("/student")
public class StudentController {
	
	
	@Autowired
	public StudentService service;
	
	@PostMapping("/addt")
	public Student addStudent(@RequestBody Student student) {
		return service.savestudent(student);
	}
	
	@PostMapping("/addAll")
	public List<Student> addStudents(@RequestBody List<Student> student){
		return service.savestudents(student);	}
	
	@GetMapping("/getStudent/{id}")
	public Optional<Student> findStudent(@PathVariable int id){
		return service.getStudent(id);
	}
	
	@GetMapping("/getAll")
	public List<Student> findAllStudents() {
		return service.getStudents();}
	
	
	@DeleteMapping("/delete/{id}")
	public String deleteStudent(@PathVariable int id) {
	    return service.deleteStudent(id);}
	

@PutMapping("/update/{id}")
     public Student updateStudent(@RequestBody Student student, @PathVariable int id) {
              return service.updateStudent(student , id);}


}