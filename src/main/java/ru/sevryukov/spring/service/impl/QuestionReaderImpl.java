package ru.sevryukov.spring.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.LocalizedMessageService;
import ru.sevryukov.spring.service.QuestionReader;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class QuestionReaderImpl implements QuestionReader {

    private final Resource file;
    private final FileStringReader fileReader;
    private final LocalizedMessageService messageService;

    public QuestionReaderImpl(@Value("${questions.fileName}") Resource file,
                              FileStringReader fileReader,
                              LocalizedMessageService messageService) {
        this.file = file;
        this.fileReader = fileReader;
        this.messageService = messageService;
    }

    @Override
    public List<Question> readQuestionsFromFile() {

        var lines = fileReader.getStrings(file.getFilename());
        var questions = new ArrayList<Question>();

        for (int i = 0; i < lines.size(); i++) {
            var line = lines.get(i);
            String[] values = line.split(",");
            if (values.length < 1) {
                var errMsg = messageService.getLocalizedMessage("exceptions.wrongFileStructure",
                        new String[]{"questions"});
                throw new RuntimeException(errMsg);
            }
            var text = values[0];
            var ans = new HashSet<>(Arrays.asList(values).subList(1, values.length));
            questions.add(new Question(i, text, ans));
        }

        return questions;
    }
}
