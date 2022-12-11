package ru.sevryukov.spring;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sevryukov.spring.service.read.impl.QuestionReaderImpl;

public class Main {
    public static void main(String[] args) {

        var ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        var service = ctx.getBean(QuestionReaderImpl.class);
        var questionList = service.readQuestionsFromFile();
        questionList.forEach(System.out::println);
    }
}