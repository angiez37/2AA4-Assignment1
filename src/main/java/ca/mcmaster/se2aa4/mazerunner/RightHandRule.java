package ca.mcmaster.se2aa4.mazerunner;
import ca.mcmaster.se2aa4.mazerunner.Block;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.PathConverter;

import java.util.Arrays;

public class RightHandRule implements MazeSolver {
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
        Direction direction = Direction.EAST;
        boolean right_wall = false;
        boolean front_wall = false;
        String path = "";

        while (!Arrays.equals(new int[] {row, col}, exit)) {
            right_wall = rightCheck(direction);
            if (right_wall) {
                front_wall = frontCheck(direction);
                if (front_wall) {
                    direction = turnLeft(direction);
                    path += "L ";
                } else {
                    moveForward(direction);
                    path += "F ";
                }
            } else {
                direction = turnRight(direction);
                moveForward(direction);
                path += "R " + "F ";
            }
        }
        return path;
    }

    public boolean checkPath(String path) {
        String user_path = PathConverter.Canonical(path);
        int[] currentPos = new int[] {row, col};
        int[] finalPos = exit;
        int[] end = {currentPos[0], currentPos[1]}; 
        boolean frontWall = false;
        boolean[] pathResults = new boolean[2];
        
        for (int i = 0; i < 2; i++) {
            Direction direction = (i == 0) ? Direction.EAST : Direction.WEST;
            currentPos = (i == 0) ? currentPos : finalPos;
            finalPos = (i == 0) ? finalPos : end;
            boolean invalid = false;
            
            for (int j = 0; j < user_path.length(); j++) {    
                try {
                    char instruction = user_path.charAt(j);
                    if (instruction == 'F') {
                        frontWall = frontCheck(direction);
                        if (frontWall) {
                            throw new Exception();
                        } else {
                            moveForward(direction);
                            currentPos[0] = row;
                            currentPos[1] = col;
                        }
                    } else if (instruction == 'R') {
                        direction = turnRight(direction);
                    } else if (instruction == 'L') {
                        direction = turnLeft(direction);
                    } else {
                        System.out.println("Usage: Path must include only L, R, and F. Factorized form of this is also acceptable.");
                        System.exit(1);
                    }
                } catch (Exception e) {
                    invalid = true;
                    pathResults[i] = false;
                    break;
                }
            }
            if (Arrays.equals(currentPos, finalPos) && !invalid) {
                pathResults[i] = true;
            } else {
                pathResults[i] = false;
            }
        }
        return pathResults[0] || pathResults[1];
    }

    private void moveForward(Direction direction) { 
        if (direction == Direction.WEST) {
            col -= 1;
        } else if (direction == Direction.EAST) {
            col += 1;
        } else if (direction == Direction.NORTH) {
            row -= 1;
        } else if (direction == Direction.SOUTH) {
            row += 1;
        }
    }

    private Direction turnRight(Direction direction) {
        if (direction == Direction.WEST) {
            return Direction.NORTH;
        } else if (direction == Direction.EAST) {
            return Direction.SOUTH;
        } else if (direction == Direction.NORTH) {
            return Direction.EAST;
        } else if (direction == Direction.SOUTH) {
            return Direction.WEST;
        }
        return direction;
    }
    
    private Direction turnLeft(Direction direction) {
        if (direction == Direction.WEST) {
            return Direction.SOUTH;
        } else if (direction == Direction.EAST) {
            return Direction.NORTH;
        } else if (direction == Direction.NORTH) {
            return Direction.WEST;
        } else if (direction == Direction.SOUTH) {
            return Direction.EAST;
        }
        return direction;
    }

    private boolean rightCheck(Direction direction) {
        if (direction == Direction.WEST) {
            return row > 0 && row - 1 >= 0 && maze.grid[row - 1][col] == Block.WALL;
        } else if (direction == Direction.EAST) {
            return row < maze.grid.length - 1 && row + 1 < maze.grid.length && maze.grid[row + 1][col] == Block.WALL;
        } else if (direction == Direction.NORTH) {
            return col < maze.grid[0].length - 1 && col + 1 < maze.grid[0].length && maze.grid[row][col + 1] == Block.WALL;
        } else if (direction == Direction.SOUTH) {
            return col > 0 && col - 1 >= 0 && maze.grid[row][col - 1] == Block.WALL;
        }
        return false;
    }

    private boolean frontCheck(Direction direction) {
        if (direction == Direction.WEST) {
            return col > 0 && maze.grid[row][col - 1] == Block.WALL;
        } else if (direction == Direction.EAST) {
            return col < maze.grid[0].length - 1 && maze.grid[row][col + 1] == Block.WALL;
        } else if (direction == Direction.NORTH) {
            return row > 0 && maze.grid[row - 1][col] == Block.WALL;
        } else if (direction == Direction.SOUTH) {
            return row < maze.grid.length - 1 && maze.grid[row + 1][col] == Block.WALL;
        }
        return false;
    }
}