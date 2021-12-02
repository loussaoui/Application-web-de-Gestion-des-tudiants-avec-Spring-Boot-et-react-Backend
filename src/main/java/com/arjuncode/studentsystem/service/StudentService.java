package com.arjuncode.studentsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.arjuncode.studentsystem.model.Student;
import com.arjuncode.studentsystem.repository.StudentRepository;

@Service
public class StudentService {
	
	@Autowired
	public StudentRepository repository;
	
	public Student savestudent(Student student) {
		return repository.save(student);}
	
	public List<Student> savestudents(List<Student> student) {
		return repository.saveAll(student);}
	
	public Optional<Student> getStudent(int id) {
		return repository.findById(id);
		}
	
	public  List<Student> getStudents(){
		return repository.findAll();
	}
	
	public String deleteStudent(int id) {
		
		repository.deleteById(id);
		return " product removed !!" + id;}
	
	public Student updateStudent(Student student ,  int id) {
        Student existingStudent = repository.findById(id).orElse(null);
        existingStudent.setFirst_name(student.getFirst_name());
        existingStudent.setLast_name(student.getLast_name());
        existingStudent.setEmail_id(student.getEmail_id());
        return repository.save(existingStudent);
    }
	
	
	
	

}
