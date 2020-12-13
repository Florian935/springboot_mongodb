package com.test.mongodb;

import com.test.mongodb.model.Student;
import com.test.mongodb.repository.StudentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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
                new Student(UUID.randomUUID().toString(), "toto1"),
                new Student(UUID.randomUUID().toString(), "toto2"),
                new Student(UUID.randomUUID().toString(), "toto3"),
                new Student(UUID.randomUUID().toString(), "toto4"),
                new Student(UUID.randomUUID().toString(), "toto5")
        );
    }
}
