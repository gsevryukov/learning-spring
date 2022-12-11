package ru.sevryukov.spring.model;

import lombok.RequiredArgsConstructor;

import java.util.Set;

@RequiredArgsConstructor
public class Question {
    private final String text;

    private final Set<String> answers;

    @Override
    public String toString() {
        var sb = new StringBuilder(text + "\n");
        answers.forEach(a -> sb.append("\t").append(a).append("\n"));
        return sb.toString();
    }
}
