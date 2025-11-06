package org.example.entity;

import org.example.entity.enums.Direction;
import org.example.entity.enums.Instruction;

import java.util.List;

public class Simulation {

    private final Grid grid;

    public Simulation(Grid grid) {
        this.grid = grid;
    }

    public void run(List<RoverInstruction> roverInstructions) {
        for (RoverInstruction instruction : roverInstructions) {
            Rover rover = new Rover(
                    instruction.startX(),
                    instruction.startY(),
                    instruction.startDirection(),
                    grid
            );

            executeInstructions(rover, instruction.commands());
            System.out.println(rover.getX() + " " + rover.getY() + " " + rover.getDirection());
        }
    }

    private void executeInstructions(Rover rover, String instructions) {
        for (char c : instructions.toCharArray()) {
            Instruction instruction = Instruction.fromChar(c);
            switch (instruction) {
                case L -> rover.turnLeft();
                case R -> rover.turnRight();
                case M -> rover.move();
            }
        }
    }
}
