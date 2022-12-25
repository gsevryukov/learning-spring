package ru.sevryukov.spring.service;

import org.springframework.lang.Nullable;

public interface LocalizedMessageService {
    String getLocalizedMessage(String code, @Nullable String[] args);
}
