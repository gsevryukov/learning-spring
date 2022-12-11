package ru.sevryukov.spring.service.read.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ClassPathResource;
import ru.sevryukov.spring.model.Question;
import ru.sevryukov.spring.service.read.QuestionReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@RequiredArgsConstructor
public class QuestionReaderImpl implements QuestionReader {

    private final String fileName;

    @Override
    public List<Question> readQuestionsFromFile() {

        var questions = new ArrayList<Question>();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new ClassPathResource(fileName).getInputStream()))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] values = line.split(",");
                if (values.length < 1) {
                    throw new RuntimeException("Wrong questions file structure!");
                }
                var text = values[0];
                var ans = new HashSet<>(Arrays.asList(values).subList(1, values.length));
                questions.add(new Question(text, ans));
            }
        } catch (IOException ex) {
            System.out.println("Error while reading a file: " + fileName + " " + ex);
        } catch (Exception ex) {
            System.out.println("Unknown error while reading a file: " + fileName + " " + ex);
        }

        return questions;
    }
}
