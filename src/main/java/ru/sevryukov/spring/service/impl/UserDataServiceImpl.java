package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.User;
import ru.sevryukov.spring.service.UserAskService;
import ru.sevryukov.spring.service.UserDataService;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserAskService userAskService;

    private static final String ENTER_USER_PATTERN = "Enter user %s...";

    @Override
    public User getUserFromInput() {
        var firstName = userAskService.askUser(String.format(ENTER_USER_PATTERN, "first name"));
        var lastName = userAskService.askUser(String.format(ENTER_USER_PATTERN, "last name"));
        return new User(firstName, lastName);
    }

}
