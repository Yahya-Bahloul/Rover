package org.example.entity;

public record Grid(int maxX, int maxY) {

    public Grid {
        if (maxX < 0 || maxY < 0) {
            throw new IllegalArgumentException("Grid size must be positive");
        }
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }
}
