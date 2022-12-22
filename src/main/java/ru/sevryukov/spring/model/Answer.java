package ru.sevryukov.spring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class Answer {

    private final int questionId;

    private final String correctAnswers;
}
