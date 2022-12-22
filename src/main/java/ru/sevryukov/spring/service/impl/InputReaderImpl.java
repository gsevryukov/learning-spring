package ru.sevryukov.spring.service.impl;


import org.springframework.stereotype.Service;
import ru.sevryukov.spring.service.InputReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
public class InputReaderImpl implements InputReader {

    @Override
    public String readInput() {
        try {
            var br = new BufferedReader(new InputStreamReader(System.in));
            return br.readLine().trim();
        } catch (IOException ex) {
            System.out.println("Input read error: " + ex);
        }
        return "";
    }
}
