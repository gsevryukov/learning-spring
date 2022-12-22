package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.config.properties.LocaleProperties;
import ru.sevryukov.spring.service.LocalizedMessageService;

@Service
@RequiredArgsConstructor
public class LocalizedMessageServiceImpl implements LocalizedMessageService {

    private final MessageSource messageSource;
    private final LocaleProperties localeProperties;

    @Override
    public String getLocalizedMessage(String code, String[] args) {
        return messageSource.getMessage(code, args, localeProperties.getLocale());
    }
}
