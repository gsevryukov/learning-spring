package ru.sevryukov.spring.service.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.Answer;
import ru.sevryukov.spring.service.AnswersService;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.LocalizedMessageService;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnswersServiceImpl implements AnswersService {

    private final Resource file;
    private final FileStringReader fileStringReader;
    private final LocalizedMessageService messageService;

    public AnswersServiceImpl(@Value("${answers.fileName}") Resource file,
                              FileStringReader fileStringReader,
                              LocalizedMessageService messageService) {
        this.file = file;
        this.fileStringReader = fileStringReader;
        this.messageService = messageService;
    }

    @Override
    public List<Answer> getCorrectAnswers() {
        var result = new ArrayList<Answer>();
        var lines = fileStringReader.getStrings(file.getFilename());
        for (var l : lines) {
            var values = l.split(",");
            if (values.length < 2) {
                var errMsg = messageService.getLocalizedMessage(
                        "exceptions.wrongFileStructure", new String[]{"answers"});
                throw new RuntimeException(errMsg);
            }
            var id = Integer.parseInt(values[0]);
            result.add(new Answer(id, values[1]));
        }
        return result;
    }
}
