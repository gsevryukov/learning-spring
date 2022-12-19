package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.service.InputReader;
import ru.sevryukov.spring.service.UserAskService;

@Service
@RequiredArgsConstructor
public class UserAskServiceImpl implements UserAskService {

    private final InputReader inputReader;

    public String askUser(String text) {
        System.out.println(text);
        var answer = inputReader.readInput();
        if (!answer.isEmpty()) {
            return answer;
        }
        return askUser(text);
    }
}
