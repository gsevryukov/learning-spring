package ru.sevryukov.spring.service.impl;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.model.User;
import ru.sevryukov.spring.service.LocalizedMessageService;
import ru.sevryukov.spring.service.UserAskService;
import ru.sevryukov.spring.service.UserDataService;

@Service
@RequiredArgsConstructor
public class UserDataServiceImpl implements UserDataService {

    private final UserAskService userAskService;
    private final LocalizedMessageService messageService;


    @Override
    public User getUserFromInput() {
        var firstNameMsg = messageService.getLocalizedMessage("userQuiz.enterFirstName", null);
        var firstName = userAskService.askUser(firstNameMsg);
        var lastNameMsg = messageService.getLocalizedMessage("userQuiz.enterLastName", null);
        var lastName = userAskService.askUser(lastNameMsg);
        return new User(firstName, lastName);
    }

}
