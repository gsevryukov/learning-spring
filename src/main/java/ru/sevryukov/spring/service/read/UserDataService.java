package ru.sevryukov.spring.service.read;

import ru.sevryukov.spring.model.User;

public interface UserDataService {

    User getUserFromInput();

    void askUser();
}
