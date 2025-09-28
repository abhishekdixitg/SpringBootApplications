package com.example.SpringBootDemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringBootDemo.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
