package ru.sevryukov.spring.service.impl;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.service.FileStringReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Service
public class FileStringReaderImpl implements FileStringReader {

    @Override
    public List<String> getStrings(String fileName) {
        var result = new ArrayList<String>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(fileName).getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                result.add(line);
            }
        } catch (IOException ex) {
            System.out.println("Error while reading a file: " + fileName + ". " + ex);
        } catch (Exception ex) {
            System.out.println("Unknown error while reading a file: " + fileName + ". " + ex);
        }
        return result;
    }
}
