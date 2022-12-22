package service;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.sevryukov.spring.config.properties.LocaleProperties;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.LocalizedMessageService;
import ru.sevryukov.spring.service.QuestionReader;
import ru.sevryukov.spring.service.impl.FileStringReaderImpl;
import ru.sevryukov.spring.service.impl.QuestionReaderImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@ContextConfiguration(classes = {
        QuestionReaderImpl.class,
        FileStringReaderImpl.class,
})
class QuestionReaderTest {

    @Autowired
    private QuestionReader questionReader;

    @Autowired
    private FileStringReader fileStringReader;

    @MockBean
    private LocaleProperties localeProperties;

    @MockBean
    private LocalizedMessageService messageService;

    @Test
    void testQuestionReader() {
        var list = questionReader.readQuestionsFromFile();
        assertEquals(2, list.size());
        var answer = list.stream().filter(q -> q.getAnswerVariants().contains("What"));
        assertNotNull(answer);
    }
}