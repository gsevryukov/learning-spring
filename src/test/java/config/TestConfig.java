package config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@TestConfiguration
@PropertySource("classpath:test.yml")
public class TestConfig {
    @Bean
    public Resource questionsFile(@Value("${questions.fileName}") String fileName) {
        return new ClassPathResource(fileName);
    }
}
