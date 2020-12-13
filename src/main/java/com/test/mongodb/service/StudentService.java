package com.test.mongodb.service;

import com.test.mongodb.model.Student;

import java.util.List;

public interface StudentService {

    List<Student> findAll();

    Student insert(Student student);

    void deleteById(String id);
}
