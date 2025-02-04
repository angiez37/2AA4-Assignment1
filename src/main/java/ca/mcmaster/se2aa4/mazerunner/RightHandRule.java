package ca.mcmaster.se2aa4.mazerunner;

import java.util.Arrays;

public class RightHandRule {
    private final Maze maze;
    private Block[][] grid;
    private int row, col;
    private int[] entry;
    private int[] exit;
    

    public RightHandRule(Maze maze) {
        this.maze = maze;
        this.entry = maze.findEntryPoint();
        this.exit = maze.findExitPoint();
        if (entry != null) {
            this.row = entry[0];
            this.col = entry[1];
        }
        Direction direction = Direction.EAST; // Start from EAST facing WEST
        boolean right_wall = false;
        boolean front_wall = false;
        String path = "";
    }

    public String solve() {

        Direction direction = Direction.EAST; // Start from EAST facing WEST
        boolean right_wall = false;
        boolean front_wall = false;
        String path = "";

        while (!Arrays.equals(new int[] {row, col}, exit)) {
            // Is there a wall to the right?
            right_wall = rightCheck(direction);
            // If yes
            if (right_wall) {
                System.out.println("Right wall identified");
                // Is there a wall in front?
                front_wall = frontCheck(direction);
                // If yes
                if (front_wall) {
                    System.out.println("Front wall identified");
                    // Turn left
                    direction = turnLeft(direction);
                    System.out.println("Left turn activated");
                    path += "L ";
                } else {
                    // Else move forward
                    System.out.println("No front wall so we move forward");
                    moveForward(direction);
                    path += "F ";
                }
            } else {
                System.out.println("No right wall so we move forward");
                // Turn right and move forward
                direction = turnRight(direction);
                moveForward(direction);
                path += "R " + "F ";
            }
        }

        return path;
    }

    private void moveForward( Direction direction) { 
        switch (direction) {
            case Direction.WEST:
                col -= 1;
                break;
            case Direction.EAST:
                col += 1;
                break;
            case Direction.NORTH:
                row -= 1;
                break;
            case Direction.SOUTH:
                row += 1;
                break;
            default:
                break;
        }
        System.out.println("Moving to: (" + row + ", " + col + ")");
    }

    private Direction turnRight(Direction direction) {
        switch (direction) {
            case Direction.WEST:
                return Direction.NORTH;
            case Direction.EAST:
                return Direction.SOUTH;
            case Direction.NORTH:
                return Direction.EAST;
            case Direction.SOUTH:
                return Direction.WEST;
            default:
                return direction;
        }
    } 
    
    
    private Direction turnLeft(Direction direction) {
        switch (direction) {
            case Direction.WEST:
                return Direction.SOUTH;
            case Direction.EAST:
                return Direction.NORTH;
            case Direction.NORTH:
                return Direction.WEST;
            case Direction.SOUTH:
                return Direction.EAST;
            default:
                return direction;
        }
    } 

    private boolean rightCheck(Direction direction) {
        switch (direction) {
            case Direction.WEST:
                return row > 0 && row - 1 >= 0 && maze.grid[row - 1][col] == Block.WALL;
            case Direction.EAST:
                return row < maze.grid.length - 1 && row + 1 < maze.grid.length && maze.grid[row + 1][col] == Block.WALL;
            case Direction.NORTH:
                return col < maze.grid[0].length - 1 && col + 1 < maze.grid[0].length && maze.grid[row][col + 1] == Block.WALL;
            case Direction.SOUTH:
                return col > 0 && col - 1 >= 0&& maze.grid[row][col - 1] == Block.WALL;
            default:
                return false;
        }
    }

    private boolean frontCheck(Direction direction) {
        switch (direction) {
            case Direction.WEST:
                return col > 0 && maze.grid[row][col - 1] == Block.WALL;
            case Direction.EAST:
                return col < maze.grid[0].length - 1 && maze.grid[row][col + 1] == Block.WALL;
            case Direction.NORTH:
                return row > 0 && maze.grid[row - 1][col] == Block.WALL;
            case Direction.SOUTH:
                return row < maze.grid.length - 1 && maze.grid[row + 1][col] == Block.WALL;
            default:
                return false;
        } 
    }

}

