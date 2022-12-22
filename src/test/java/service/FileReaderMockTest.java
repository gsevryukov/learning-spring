package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.QuestionReader;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {FileStringReader.class, QuestionReader.class})
class FileReaderMockTest {

    @MockBean
    FileStringReader fileStringReader;

    @MockBean
    QuestionReader questionReader;

    @BeforeEach
    public void prepareData() {
        when(questionReader.readQuestionsFromFile())
                .thenReturn(List.of(Mockito.mock(Question.class)));
    }

    @Test
    void testFileStringReader() {
        assertNotNull(questionReader);
        var lines = questionReader.readQuestionsFromFile();
        assertEquals(1, lines.size());
    }
}
