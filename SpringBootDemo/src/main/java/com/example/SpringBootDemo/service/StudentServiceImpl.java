package com.example.SpringBootDemo.service;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.SpringBootDemo.model.Student;
import com.example.SpringBootDemo.repository.StudentRepository;

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository studentRepository;

	@Override
	public void addStudent() {
		ArrayList<Student> student = new ArrayList<Student>();
		student.add(new Student("100101", "Shubham"));
		student.add(new Student("20010", "Puneet"));

		for (Student stud : student) {
			studentRepository.save(stud);
		}

	}

	@Override
	public void deleteAllData() {
		studentRepository.deleteAll();

	}

	@Override
	public ArrayList<Student> findAllStudent() {
		return (ArrayList<Student>) studentRepository.findAll();
	}

	@Override
	public Student findAllStudentByID(String id) {
		Optional<Student> opt = studentRepository.findById(id);
		if (opt.isPresent()) {
			return opt.get();
		}
		return null;
	}

}
