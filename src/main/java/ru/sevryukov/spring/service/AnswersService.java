package ru.sevryukov.spring.service;


import ru.sevryukov.spring.model.Answer;

import java.util.List;

public interface AnswersService {

    List<Answer> getCorrectAnswers();
}
