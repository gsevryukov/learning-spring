package ru.sevryukov.spring.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Answer;
import ru.sevryukov.spring.service.AnswersService;
import ru.sevryukov.spring.service.ValidationService;

import java.util.Map;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final int passThreshold;

    private final AnswersService answersService;

    public ValidationServiceImpl(@Value("${studentTest.passThreshold}") int passThreshold,
                                 AnswersService answersService) {
        this.passThreshold = passThreshold;
        this.answersService = answersService;
    }

    @Override
    public String validateAnswers(Map<Integer, Answer> userAnswers) {
        var sb = new StringBuilder("Results: \n");
        var correctAnswers = answersService.getCorrectAnswers();
        var correctCounter = 0;
        for (var answer : correctAnswers) {
            var userAnswer = userAnswers.get(answer.getQuestionId());
            if (userAnswer != null) {
                if (answer.getCorrectAnswers().equals(userAnswer.getCorrectAnswers())) {
                    sb.append(answer.getQuestionId()).append(" -- ").append("Correct!").append("\n");
                    correctCounter++;
                } else {
                    sb.append(userAnswer.getQuestionId()).append(" -- ").append("Incorrect!").append("\n");
                }
            }
        }
        var end = correctCounter >= passThreshold ? "Test passed. Nice job!" : "Test failed. Try again!";
        return sb.append("\n").append(end).toString();
    }
}
