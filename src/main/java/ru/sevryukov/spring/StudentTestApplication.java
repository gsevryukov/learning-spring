package ru.sevryukov.spring;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import ru.sevryukov.spring.config.properties.LocaleProperties;
import ru.sevryukov.spring.service.UserQuizService;

@SpringBootApplication
@RequiredArgsConstructor
@EnableConfigurationProperties(LocaleProperties.class)
public class StudentTestApplication implements CommandLineRunner {

    private final UserQuizService userQuizService;

    public static void main(String[] args) {
        SpringApplication.run(StudentTestApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userQuizService.quizUser();
    }
}
