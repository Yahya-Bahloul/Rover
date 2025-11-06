package org.example.entity;

import org.example.entity.enums.Direction;
import java.util.Map;

public class Rover {

    private int x;
    private int y;
    private Direction direction;
    private Grid grid; // this could be final if no planing to change map later

    public Rover(int initX, int initY, Direction initDirection, Grid grid) {
        if (initDirection == null) {
            throw new IllegalArgumentException("Initial direction must not be null");
        }

        if (!grid.isInside(initX, initY)){
            throw new IllegalArgumentException("Initial coordinates out of grid bounds");
        }

        this.x = initX;
        this.y = initY;
        this.direction = initDirection;
        this.grid = grid;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Direction getDirection() {
        return direction;
    }

    public Grid getGrid() {
        return grid;
    }

    public void turnLeft(){
        this.direction = getCurrentLeft();
    }

    public void turnRight(){
        this.direction = getCurrentRight();
    }

    public void move() {
        switch (direction) {
            case N:
                moveY(y + 1);
                break;
            case W:
                moveX(x - 1);
                break;
            case S:
                moveY(y - 1);
                break;
            case E:
                moveX(x + 1);
                break;
            default:
                throw new IllegalStateException("Unexpected direction: " + direction);
        }
    }

    private Direction getCurrentLeft(){
        return switch (direction) {
            case N -> Direction.W;
            case W -> Direction.S;
            case S -> Direction.E;
            case E -> Direction.N;
            default -> throw new IllegalStateException("Unknown direction: " + direction);
        };
    }

    private Direction getCurrentRight() {
        return switch (direction) {
            case N -> Direction.E;
            case E -> Direction.S;
            case S -> Direction.W;
            case W -> Direction.N;
            default -> throw new IllegalStateException("Unknown direction: " + direction);
        };
    }

    private void moveX(int newX){
        if(grid.isInside(newX, y)){
            this.x = newX;
        }
    }

    private void moveY(int newY){
        if(grid.isInside(x, newY)){
            this.y = newY;
        }
    }
}
