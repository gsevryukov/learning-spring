package ru.sevryukov.spring.model;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

@Getter
@RequiredArgsConstructor
public class Question {
    private final int id;

    private final String text;

    private final Set<String> answerVariants;

    @Override
    public String toString() {
        var sb = new StringBuilder(text + "\n");
        answerVariants.forEach(a -> sb.append("\t").append(a).append("\n"));
        return sb.toString();
    }
}
