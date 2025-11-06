package org.example.entity;

import org.example.entity.enums.Direction;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertEquals;


class SimulationTest {

    @Test
    void shouldExecuteInstructionsCorrectly() {
        Grid grid = new Grid(5, 5);
        Simulation simulation = new Simulation(grid);

        RoverInstruction instr = new RoverInstruction(1, 2, Direction.N, "LMLMLMLMM");
        RoverInstruction instr2 = new RoverInstruction(3, 3, Direction.E, "MMRMMRMRRM");
        List<RoverInstruction> list = List.of(instr, instr2);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream original = System.out;
        System.setOut(new PrintStream(out));

        simulation.run(list);

        System.setOut(original);
        String[] lines = out.toString().strip().split("\\R");

        assertEquals("1 3 N", lines[0]);
        assertEquals("5 1 E", lines[1]);
    }
}
