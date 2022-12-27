package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;
import ru.sevryukov.spring.service.ShellRunnerService;
import ru.sevryukov.spring.service.UserQuizService;

@ShellComponent
@RequiredArgsConstructor
public class ShellRunnerServiceImpl implements ShellRunnerService {

    private final UserQuizService userQuizService;

    @Override
    @ShellMethod(key = "quiz", value = "Start quiz!")
    public void runInShell() {
        userQuizService.quizUser();
    }

}
