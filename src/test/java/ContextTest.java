import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.sevryukov.spring.StudentTestApplication;
import ru.sevryukov.spring.service.impl.QuestionReaderImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContextTest {

    @Test
    void contextLoadTest() {
        var ctx = new AnnotationConfigApplicationContext(StudentTestApplication.class);
        var questionReader = ctx.getBean(QuestionReaderImpl.class);
        assertNotNull(questionReader);
        var questionList = questionReader.readQuestionsFromFile();
        assertEquals(5, questionList.size());
        ctx.close();
    }
}