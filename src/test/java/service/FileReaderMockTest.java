package service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.core.io.Resource;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.impl.QuestionReaderImpl;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FileReaderMockTest {

    @Mock
    FileStringReader fileStringReader;

    @Mock
    Resource file;

    @BeforeEach
    public void prepareData() {
        when(fileStringReader.getStrings(any())).thenReturn(List.of("1", "2", "3"));
    }

    @Test
    void testFileStringReader() {
        var questionsReader = new QuestionReaderImpl(file, fileStringReader);
        Assertions.assertNotNull(questionsReader);
        var lines = questionsReader.readQuestionsFromFile();
        Assertions.assertEquals(3, lines.size());
    }
}
