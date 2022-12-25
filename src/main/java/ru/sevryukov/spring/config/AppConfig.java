package ru.sevryukov.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import ru.sevryukov.spring.config.properties.LocaleProperties;

@Configuration
@EnableConfigurationProperties(LocaleProperties.class)
@RequiredArgsConstructor
public class AppConfig {

    private final LocaleProperties localeProperties;

    @Bean
    public Resource questionsFile(@Value("${questions.fileName}") String fileName) {
        return getResourceByName(fileName);
    }

    @Bean
    public Resource answersFile(@Value("${answers.fileName}") String fileName) {
        return getResourceByName(fileName);
    }

    private Resource getResourceByName(String fileName) {
        var name = fileName +  "_" + localeProperties.getLocale().toString();
        return new ClassPathResource(name);
    }
}
