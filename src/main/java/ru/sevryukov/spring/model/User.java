package ru.sevryukov.spring.model;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class User {

    private final String firstName;

    private final String lastName;

}
