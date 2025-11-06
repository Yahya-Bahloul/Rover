package org.example.helper.adapter;

import org.example.entity.Grid;
import org.example.entity.ParsedInput;
import org.example.entity.RoverInstruction;
import org.example.entity.enums.Direction;
import org.example.helper.InputReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextInputParser {

    private final InputReader inputReader;

    public TextInputParser(InputReader inputReader) {
        this.inputReader = inputReader;
    }

    public ParsedInput parse(String path) throws IOException {
        List<String> lines = inputReader.readLines(path);

        String[] gridSize = lines.get(0).trim().split(" ");
        int maxX = Integer.parseInt(gridSize[0]);
        int maxY = Integer.parseInt(gridSize[1]);
        Grid grid = new Grid(maxX, maxY);

        List<RoverInstruction> roverInstructions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i += 2) {
            String[] roverData = lines.get(i).trim().split(" ");
            int x = Integer.parseInt(roverData[0]);
            int y = Integer.parseInt(roverData[1]);
            Direction dir = Direction.valueOf(roverData[2]);
            String commands = lines.get(i + 1).trim();

            roverInstructions.add(new RoverInstruction(x, y, dir, commands));
        }

        return new ParsedInput(grid, roverInstructions);
    }
}
