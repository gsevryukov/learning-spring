package ru.sevryukov.spring.service.impl;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.service.InputReader;
import ru.sevryukov.spring.service.LocalizedMessageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Slf4j
@Service
@RequiredArgsConstructor
public class InputReaderImpl implements InputReader {

    private final LocalizedMessageService messageService;

    @Override
    public String readInput() {
        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine().trim();
        } catch (IOException ex) {
            var msg = messageService.getLocalizedMessage("exceptions.generalError", new String[]{ex.toString()});
            log.error(msg);
        }
        return "";
    }
}
