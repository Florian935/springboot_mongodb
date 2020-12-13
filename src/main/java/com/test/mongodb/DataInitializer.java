package com.test.mongodb;

import com.test.mongodb.model.Student;
import com.test.mongodb.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class DataInitializer {

    private final StudentRepository studentRepository;

    public DataInitializer(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @EventListener(value = ContextRefreshedEvent.class)
    public void init() {
        log.info("start data initialization ...");

        this.studentRepository.deleteAll();
        this.studentRepository.insert(initializeStudents());

        log.info("done initialization...");
    }

    private List<Student> initializeStudents() {

        return List.of(
                new Student(null, "toto1"),
                new Student(null, "toto2"),
                new Student(null, "toto3"),
                new Student(null, "toto4"),
                new Student(null, "toto5")
        );
    }
}
