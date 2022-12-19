package ru.sevryukov.spring.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.QuestionReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class QuestionReaderImpl implements QuestionReader {

    private final Resource file;
    private final FileStringReader fileReader;

    public QuestionReaderImpl(@Value("${questions.file.name}") Resource file,
                              FileStringReader fileReader) {
        this.file = file;
        this.fileReader = fileReader;
    }

    @Override
    public List<Question> readQuestionsFromFile() {

        var lines = fileReader.getStrings(file.getFilename());
        var questions = new ArrayList<Question>();

        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            String[] values = line.split(",");
            if (values.length < 1) {
                throw new RuntimeException("Wrong questions file structure!");
            }
            var text = values[0];
            var ans = new HashSet<>(Arrays.asList(values).subList(1, values.length));
            questions.add(new Question(i, text, ans));
        }

        return questions;
    }
}
