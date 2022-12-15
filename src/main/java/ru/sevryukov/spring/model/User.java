package ru.sevryukov.spring.model;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class User {
    private final String firstName;
    private final String lastName;

}
