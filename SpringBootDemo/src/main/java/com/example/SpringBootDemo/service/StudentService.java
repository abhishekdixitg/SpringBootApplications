package com.example.SpringBootDemo.service;

import java.util.ArrayList;

import com.example.SpringBootDemo.model.Student;

public interface StudentService {

	void addStudent();

	void deleteAllData();

	ArrayList<Student> findAllStudent();

	Student findAllStudentByID(String id);
}
