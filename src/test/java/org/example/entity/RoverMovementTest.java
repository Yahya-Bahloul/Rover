package org.example.entity;

import org.example.entity.enums.Direction;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoverMovementTest {

    int init_x = 2;
    int init_y = 1;
    Direction init_direction = Direction.N;

    Grid grid = new Grid(5, 5);

    private Rover rover = new Rover(init_x, init_y, init_direction, grid);

    @Test
    public void shouldPlaceRoverInCorrectInitialPos(){
        assertEquals(init_x, rover.getX());
        assertEquals(init_y, rover.getY());
        assertEquals(init_direction, rover.getDirection());
    }

    @Test
    public void shouldMoveNorth(){
        rover = new Rover(init_x, init_y, Direction.N, grid);

        rover.move();

        assertEquals(init_y+1, rover.getY());
        assertEquals(init_x, rover.getX());
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void shouldMoveWest(){
        rover = new Rover(init_x, init_y, Direction.W, grid);

        rover.move();

        assertEquals(init_y, rover.getY());
        assertEquals(init_x-1, rover.getX());
    }

    @Test
    public void shouldMoveSouth(){
        rover = new Rover(init_x, init_y, Direction.S, grid);

        rover.move();

        assertEquals(init_y-1, rover.getY());
        assertEquals(init_x, rover.getX());
    }

    @Test
    public void shouldMoveEast(){
        rover = new Rover(init_x, init_y, Direction.E, grid);

        rover.move();

        assertEquals(init_y, rover.getY());
        assertEquals(init_x+1, rover.getX());
    }

    @Test
    public void shouldNotMoveEast(){
        rover = new Rover(0, init_y, Direction.W, grid);

        rover.move();

        assertEquals(init_y, rover.getY());
        assertEquals(0, rover.getX());
    }

    @Test
    public void shouldNotMoveNorth(){
        rover = new Rover(init_x, grid.getMaxY(), Direction.N, grid);

        rover.move();

        assertEquals(grid.getMaxY(), rover.getY());
        assertEquals(init_x, rover.getX());
    }

    @Test
    public void shouldTurnLeftCorrectly() {
        rover = new Rover(init_x, init_y, Direction.N, grid);
        rover.turnLeft();
        assertEquals(Direction.W, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.W, grid);
        rover.turnLeft();
        assertEquals(Direction.S, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.S, grid);
        rover.turnLeft();
        assertEquals(Direction.E, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.E, grid);
        rover.turnLeft();
        assertEquals(Direction.N, rover.getDirection());
    }

    @Test
    public void shouldTurnRightCorrectly() {
        rover = new Rover(init_x, init_y, Direction.N, grid);
        rover.turnRight();
        assertEquals(Direction.E, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.E, grid);
        rover.turnRight();
        assertEquals(Direction.S, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.S, grid);
        rover.turnRight();
        assertEquals(Direction.W, rover.getDirection());

        rover = new Rover(init_x, init_y, Direction.W, grid);
        rover.turnRight();
        assertEquals(Direction.N, rover.getDirection());
    }
}