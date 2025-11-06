package org.example.entity;

public class Grid {
    private final int maxX;
    private final int maxY;

    public Grid(int maxX, int maxY) {
        if (maxX < 0 || maxY < 0)
            throw new IllegalArgumentException("Grid size must be positive");
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public boolean isInside(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY(){
        return maxY;
    }
}
