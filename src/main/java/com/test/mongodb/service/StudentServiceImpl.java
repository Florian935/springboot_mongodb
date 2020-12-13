package com.test.mongodb.service;

import com.test.mongodb.model.Student;
import com.test.mongodb.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student insert(Student student) {
        return studentRepository.insert(student);
    }

    @Override
    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
