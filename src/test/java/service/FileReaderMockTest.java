package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.LocalizedMessageService;
import ru.sevryukov.spring.service.QuestionReader;
import ru.sevryukov.spring.service.impl.QuestionReaderImpl;

import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@SpringBootTest
@ContextConfiguration(classes = {QuestionReaderImpl.class})
class FileReaderMockTest {

    @Autowired
    QuestionReader questionReader;
    @MockBean
    FileStringReader fileStringReader;
    @MockBean
    LocalizedMessageService localizedMessageService;
    @MockBean
    Resource questionsFile;

    private Question testQuestion;
    private static final String questionText = "Are you testing me?";
    private static final String answer = "Yes";
    private static final String answer1 = "No";
    private static final String answer2 = "Why should I?";


    @BeforeEach
    public void prepareData() {
        testQuestion = new Question(0, questionText, Set.of(answer, answer1, answer2));
        var linesFromFile = String.join(",", questionText, answer, answer1, answer2);
        when(fileStringReader.getStrings(questionsFile.getFilename()))
                .thenReturn(List.of(linesFromFile));
    }

    @Test
    void testFileStringReader() {
        var questions = questionReader.readQuestionsFromFile();
        assertNotNull(questions);
        assertEquals(1, questions.size());
        var question = questions.get(0);
        assertNotNull(question);
        assertAll(() -> {
            assertEquals(question.getId(), testQuestion.getId());
            assertEquals(question.getText(), testQuestion.getText());
            assertEquals(question.getAnswerVariants().size(), testQuestion.getAnswerVariants().size());
        });
    }
}
