package org.example.helper.adapter;

import org.example.helper.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.Assert.assertThrows;


class TextInputReaderTest {

    private final InputReader reader = new TXTInputFileReader();

    @TempDir
    Path tempDir;

    @Test
    void shouldReadAllLinesFromFile() throws IOException {
        Path file = tempDir.resolve("test.txt");
        Files.write(file, List.of("Line 1", "Line 2", "Line 3"));
        List<String> lines = reader.readLines(file.toString());
        Assertions.assertEquals(3, lines.size());
        Assertions.assertEquals("Line 1", lines.get(0));
        Assertions.assertEquals("Line 3", lines.get(2));
    }

    @Test
    void shouldThrowExceptionWhenPathIsNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.readLines(null));
    }

    @Test
    void shouldThrowExceptionWhenPathIsEmpty() {
        assertThrows(IllegalArgumentException.class, () -> reader.readLines("  "));
    }

    @Test
    void shouldThrowIOExceptionWhenFileDoesNotExist() {
        assertThrows(IOException.class, () -> reader.readLines("not_found.txt"));
    }
}
