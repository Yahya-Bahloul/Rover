package org.example.helper.adapter;

import org.example.entity.Grid;
import org.example.entity.ParsedInput;
import org.example.entity.RoverInstruction;
import org.example.entity.enums.Direction;
import org.example.helper.InputParser;
import org.example.helper.InputReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;


class TextInputParserTest {

    @Test
    void shouldParseValidInputFile() throws IOException {
        InputReader reader = path -> List.of(
                "5 5",
                "1 2 N",
                "LMLMLMLMM",
                "3 3 E",
                "MMRMMRMRRM"
        );
        InputParser parser = new TextInputParser(reader);
        ParsedInput parsed = parser.parse("test.txt");

        Grid grid = parsed.grid();
        Assertions.assertEquals(5, grid.maxX());
        Assertions.assertEquals(5, grid.maxY());

        List<RoverInstruction> rovers = parsed.roverInstructions();
        Assertions.assertEquals(2, rovers.size());
        Assertions.assertEquals(1, rovers.get(0).startX());
        Assertions.assertEquals(2, rovers.get(0).startY());
        Assertions.assertEquals(Direction.N, rovers.get(0).startDirection());
        Assertions.assertEquals("LMLMLMLMM", rovers.get(0).commands());
    }

    @Test
    void shouldThrowWhenInvalidGridLine() throws IOException {
        InputReader reader = path -> List.of("invalid line");
        InputParser parser = new TextInputParser(reader);
        Assertions.assertThrows(NumberFormatException.class, () -> parser.parse("test.txt"));
    }

    @Test
    void shouldThrowWhenMissingLines() throws IOException {
        InputReader reader = path -> List.of("5 5", "1 2 N");
        InputParser parser = new TextInputParser(reader);
        Assertions.assertThrows(IndexOutOfBoundsException.class, () -> parser.parse("test.txt"));
    }
}
