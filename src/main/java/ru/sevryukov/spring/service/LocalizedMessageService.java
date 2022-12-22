package ru.sevryukov.spring.service;

import jakarta.annotation.Nullable;

public interface LocalizedMessageService {
    String getLocalizedMessage(String code, @Nullable String[] args);
}
