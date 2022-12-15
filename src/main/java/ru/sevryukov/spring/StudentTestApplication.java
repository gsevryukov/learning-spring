package ru.sevryukov.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import ru.sevryukov.spring.service.read.UserDataService;

@Configuration
@ComponentScan
public class StudentTestApplication {
    public static void main(String[] args) {

        var ctx = new AnnotationConfigApplicationContext(StudentTestApplication.class);
        var s = ctx.getBean(UserDataService.class);
        s.askUser();
    }
}