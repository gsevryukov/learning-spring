package service;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import ru.sevryukov.spring.service.QuestionReader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringJUnitConfig
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestConfig.class,
        loader = AnnotationConfigContextLoader.class
)
class QuestionReaderTest {

    @Autowired
    private QuestionReader questionReader;

    @Test
    void testQuestionReader() {
        var list = questionReader.readQuestionsFromFile();
        assertEquals(2, list.size());
        var answer = list.stream().filter(q -> q.getAnswerVariants().contains("What"));
        assertNotNull(answer);
    }
}