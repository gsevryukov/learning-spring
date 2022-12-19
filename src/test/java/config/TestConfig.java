package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.QuestionReader;
import ru.sevryukov.spring.service.impl.FileStringReaderImpl;
import ru.sevryukov.spring.service.impl.QuestionReaderImpl;

@Configuration
@ComponentScan("config")
@PropertySource("classpath:test.properties")
public class TestConfig {

    @Bean
    public Resource file(@Value("${questions.file.name}") String filePath) {
        return new ClassPathResource(filePath);
    }

    @Bean
    public FileStringReader fileStringReader() {
        return new FileStringReaderImpl();
    }

    @Bean
    public QuestionReader questionReader(Resource file, FileStringReader fileStringReader) {
        return new QuestionReaderImpl(file, fileStringReader);
    }
}
