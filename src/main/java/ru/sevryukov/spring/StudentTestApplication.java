package ru.sevryukov.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import ru.sevryukov.spring.service.UserQuizService;

@Configuration
@ComponentScan
@PropertySource("classpath:application.properties")
public class StudentTestApplication {
    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(StudentTestApplication.class);
        var quizService = ctx.getBean(UserQuizService.class);
        quizService.quizUser();
        ctx.close();
    }
}