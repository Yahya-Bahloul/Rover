package org.example.helper.adapter;

import org.example.helper.InputReader;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class TXTInputFileReader implements InputReader {

    @Override
    public List<String> readLines(String path) throws IOException {
        if (path == null || path.isBlank()) {
            throw new IllegalArgumentException("File path must not be null or empty");
        }
        return Files.readAllLines(Path.of(path));
    }


}
