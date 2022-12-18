package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Answer;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.InputReader;
import ru.sevryukov.spring.service.QuestionReader;
import ru.sevryukov.spring.service.UserDataService;
import ru.sevryukov.spring.service.UserQuizService;
import ru.sevryukov.spring.service.ValidationService;

import java.util.HashMap;

@Service
@RequiredArgsConstructor
public class UserQuizServiceImpl implements UserQuizService {

    private final UserDataService userDataService;

    private final ValidationService validationService;

    private final QuestionReader questionReader;

    private final InputReader inputReader;


    @Override
    public void quizUser() {
        var user = userDataService.getUserFromInput();
        System.out.println("Hello, " + user.getFirstName() + " " + user.getLastName() + "!");
        var questions = questionReader.readQuestionsFromFile();
        var userAnswers = new HashMap<Integer, Answer>();
        for (var q : questions) {
            var answer = askQuestion(q);
            if (!answer.isEmpty()) {
                userAnswers.put(q.getId(), new Answer(q.getId(), answer));
            }
        }
        System.out.println(validationService.validateAnswers(userAnswers));
    }

    private String askQuestion(Question q) {
        System.out.println(q);
        var answer = inputReader.readInput();
        if (!answer.isEmpty()) {
            return answer;
        }
        return askQuestion(q);
    }
}
