package org.example.entity;

import org.example.entity.enums.Direction;

public record RoverInstruction(int startX, int startY, Direction startDirection, String commands) { }
