package com.example.SpringBootDemo.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.service.StudentService;

@RestController
@RequestMapping("/student")
public class SpringBootApplicationController {

	Map<String, Student> studentMap = new HashMap<>();

	@Autowired
	StudentService service;

	@PostMapping("/addStudent")
	public boolean addStudent(@RequestBody Student student) {
		studentMap.put(student.getId(), student);
		return true;
	}

	@GetMapping("/name")
	public String getName() {
		return "Abhishek";
	}

	@GetMapping("/students")
	public Collection<Student> getStudents() {

		return service.findAllStudent();
	}

	@PutMapping("/update/{id}")
	public boolean getStudents(@PathVariable String id, @RequestBody Student student) {
		/// Student student1 = studentMap.get(id);
		studentMap.put(id, student);
		return true;
	}

}
