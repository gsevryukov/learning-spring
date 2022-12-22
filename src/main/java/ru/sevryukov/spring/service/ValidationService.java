package ru.sevryukov.spring.service;


import ru.sevryukov.spring.model.Answer;

import java.util.Map;

public interface ValidationService {

    String validateAnswers(Map<Integer, Answer> userAnswers);
}
