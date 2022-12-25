package ru.sevryukov.spring.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Answer;
import ru.sevryukov.spring.service.AnswersService;
import ru.sevryukov.spring.service.LocalizedMessageService;
import ru.sevryukov.spring.service.ValidationService;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class ValidationServiceImpl implements ValidationService {

    private final int passThreshold;

    private final AnswersService answersService;

    private final LocalizedMessageService messageService;

    @Override
    public String validateAnswers(Map<Integer, Answer> userAnswers) {
        var results = messageService.getLocalizedMessage("messages.results", null);
        var sb = new StringBuilder(results).append("\n");
        var correctAnswers = answersService.getCorrectAnswers();
        var correctCounter = 0;
        for (var answer : correctAnswers) {
            var userAnswer = userAnswers.get(answer.getQuestionId());
            if (userAnswer != null) {
                if (answer.getCorrectAnswers().equals(userAnswer.getCorrectAnswers())) {
                    var correct = messageService.getLocalizedMessage("messages.correct", null);
                    sb.append(answer.getQuestionId()).append(" -- ").append(correct).append("\n");
                    correctCounter++;
                } else {
                    var incorrect = messageService.getLocalizedMessage("messages.incorrect", null);
                    sb.append(userAnswer.getQuestionId()).append(" -- ").append(incorrect).append("\n");
                }
            }
        }
        var end = getResultString(correctCounter);
        return sb.append("\n").append(end).toString();
    }

    private String getResultString(int correctCounter) {
        if (correctCounter >= passThreshold) {
            return messageService.getLocalizedMessage("messages.testPassed", null);
        } else {
            return messageService.getLocalizedMessage("messages.testFailed", null);
        }
    }
}
