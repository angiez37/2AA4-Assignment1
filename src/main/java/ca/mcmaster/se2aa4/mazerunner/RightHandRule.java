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
                // Is there a wall in front?
                front_wall = frontCheck(direction);
                // If yes
                if (front_wall) {
                    // Turn left
                    direction = turnLeft(direction);
                    path += "L ";
                } else {
                    // Else move forward
                    moveForward(direction);
                    path += "F ";
                }
            } else {
                // Turn right and move forward
                direction = turnRight(direction);
                moveForward(direction);
                path += "R " + "F ";
            }
        }

        return path;
    }

    public boolean checkPath(String path) {
        String user_path = PathConverter.Canonical(path); // First convert path to Canonical form
        int []currentPos = new int[] {row, col};
        int []finalPos = exit;
        int[] end = {currentPos[0], currentPos[1]}; 
        boolean frontWall = false;
        boolean[] pathResults = new boolean[2]; // Holds the result [[path valid from right-left?],[path valid from left-right]]
        
        // Test the path from left-right, then right-left
        for (int i = 0; i < 2; i++) {
            // Determine initial positions and directions
            Direction direction = (i == 0) ? Direction.EAST : Direction.WEST;
            currentPos = (i == 0) ? currentPos: finalPos;
            finalPos = (i == 0) ? finalPos: end;
            boolean invalid = false; // whether an invalid instruction was encountered in path
            
            // Go through path instructions and apply them
            for (int j = 0; j < user_path.length(); j++) {    
                try {
                    switch (user_path.charAt(j)) {
                        case 'F':
                            frontWall = frontCheck(direction);
                            if (frontWall) {
                                // If a wall is present, path is immediately invalid
                                throw new Exception();
                            } else {
                                moveForward(direction);
                                currentPos[0] = row; // Ensure current position is updated correctly
                                currentPos[1] = col;
                            }
                            break;
                        case 'R':
                            direction = turnRight(direction);
                            break;
                        case 'L':
                            direction = turnLeft(direction);
                            break;
                        default:
                            // When an incorrect instruction is provided
                            System.out.println("Usage: Path must include only L, R, and F. Factorized form of this is also acceptable.");
                            System.exit(1);
                    }
                } catch (Exception e) {
                    invalid = true;
                    pathResults[i] = false; // Path from left-right or right-left is invalid
                    break;
                }
            }
            
            // Path is correct if we ended up in the final position and didn't encounter an invalid instruction
            if (Arrays.equals(currentPos, finalPos) && !invalid) {
                pathResults[i] = true;
            } else {
                pathResults[i] = false;
            }
        }
        
        // Path is valid if either left-right or right-left is valid
        if (pathResults[0] || pathResults[1]) {
            return true;
        }
        else {
            return false;
        }
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

