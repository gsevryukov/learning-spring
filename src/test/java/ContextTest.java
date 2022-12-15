import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import ru.sevryukov.spring.service.read.impl.QuestionReaderImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class ContextTest {

    @Test
    void contextLoadTest() {
        var ctx = new ClassPathXmlApplicationContext("/spring-context.xml");
        var questionReader = ctx.getBean(QuestionReaderImpl.class);
        assertNotNull(questionReader);
        var questionList = questionReader.readQuestionsFromFile();
        assertEquals(5, questionList.size());
        ctx.close();
    }
}