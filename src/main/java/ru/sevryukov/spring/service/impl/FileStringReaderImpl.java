package ru.sevryukov.spring.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import ru.sevryukov.spring.service.FileStringReader;
import ru.sevryukov.spring.service.LocalizedMessageService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class FileStringReaderImpl implements FileStringReader {

    private final LocalizedMessageService messageService;

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
            var msg = messageService.getLocalizedMessage("exceptions.fileOpenError",
                    new String[]{fileName, ex.toString()});
            log.error(msg);
        } catch (Exception ex) {
            var msg = messageService.getLocalizedMessage("exceptions.generalError", new String[]{ex.toString()});
            log.error(msg);
        }
        return result;
    }
}
