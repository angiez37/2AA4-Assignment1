package ca.mcmaster.se2aa4.mazerunner;

public class RightHandRule {
    private final Maze maze;
    private Block[][] grid;
    private int row, col;
    private final int[] entry = maze.findEntryPoint();
    private final int[] exit = maze.findExitPoint();
    

    public RightHandRule(Maze maze) {
        this.maze = maze;
        this.entry = maze.findEntryPoint();
        this.exit = maze.findExitPoint();
        if (entry != null) {
            this.row = entry[0];
            this.col = entry[1];
        }
        Direction dir = Direction.WEST; // Start from EAST facing WEST
        boolean right_wall = false;
        boolean front_wall = false;
        String path = "";
    }

    public void solve() {

        Direction direction = Direction.WEST; // Start from EAST facing WEST
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
    }

    private void moveForward( Direction direction) { 
        switch (direction) {
            case Direction.WEST:
                col -= 1;
            case Direction.EAST:
                col += 1;
            case Direction.NORTH:
                row -= 1;
            case Direction.SOUTH:
                row += 1;
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
                if (maze.grid[row - 1][col] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.EAST:
                if (maze.grid[row + 1][col] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.NORTH:
                if (maze.grid[row][col + 1] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.SOUTH:
                if (maze.grid[row][col - 1] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        }
    }

    private boolean frontCheck(Direction direction) {
        switch (direction) {
            case Direction.WEST:
                if (maze.grid[row][col - 1] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.EAST:
                if (maze.grid[row][col + 1] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.NORTH:
                if (maze.grid[row - 1][col] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            case Direction.SOUTH:
                if (maze.grid[row + 1][col] == Tile.WALL) {
                    return true;
                } else {
                    return false;
                }
            default:
                return false;
        } 
    }

}

