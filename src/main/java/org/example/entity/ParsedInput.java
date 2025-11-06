package org.example.entity;

import java.util.List;

public record ParsedInput(Grid grid, List<RoverInstruction> roverInstructions) { }
