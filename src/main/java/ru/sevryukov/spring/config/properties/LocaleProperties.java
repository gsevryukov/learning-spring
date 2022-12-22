package ru.sevryukov.spring.config.properties;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Locale;

@Getter
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "localisation")
public class LocaleProperties {
    private final Locale locale;
}
