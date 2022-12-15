package ru.sevryukov.spring.service.read.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.User;
import ru.sevryukov.spring.service.input.InputReader;
import ru.sevryukov.spring.service.read.UserDataService;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final InputReader inputReader;

    @Override
    public User getUserFromInput() {
        System.out.println("Enter user first name...");
        var firstName = inputReader.readInput();
        System.out.println("Enter user last name...");
        var lastName = inputReader.readInput();
        return new User(firstName, lastName);
    }

    @Override
    public void askUser() {
        var user = getUserFromInput();
        System.out.println("user is: " + user);
    }

}
