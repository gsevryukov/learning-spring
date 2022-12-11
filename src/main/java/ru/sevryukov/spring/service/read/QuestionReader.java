package ru.sevryukov.spring.service.read;

import ru.sevryukov.spring.model.Question;

import java.util.List;

public interface QuestionReader {

    List<Question> readQuestionsFromFile();
}
