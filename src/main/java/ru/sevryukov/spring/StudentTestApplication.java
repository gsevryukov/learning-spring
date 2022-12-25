package ru.sevryukov.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class StudentTestApplication {

    public static void main(String[] args) {
        SpringApplication.run(StudentTestApplication.class, args);
    }
}
