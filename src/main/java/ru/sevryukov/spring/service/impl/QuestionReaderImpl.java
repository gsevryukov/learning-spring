package ru.sevryukov.spring.service.impl;


import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
public class QuestionReaderImpl implements QuestionReader {

    private final Resource questionsFile;
    private final FileStringReader fileReader;
    private final LocalizedMessageService messageService;

    @Override
    public List<Question> readQuestionsFromFile() {

        var lines = fileReader.getStrings(questionsFile.getFilename());
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
