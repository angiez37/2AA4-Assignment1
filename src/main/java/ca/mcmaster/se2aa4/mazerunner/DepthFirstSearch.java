package ca.mcmaster.se2aa4.mazerunner;

import ca.mcmaster.se2aa4.mazerunner.Block;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.PathConverter;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class DepthFirstSearch implements MazeSolver {
    private final Maze maze;
    private int[] entry;
    private int[] exit;
    private boolean[][] visited;
    private Stack<Direction> pathStack;
    private Set<String> visitedPositions;

    public DepthFirstSearch(Maze maze) {
        this.maze = maze;
        this.entry = maze.findEntryPoint();
        this.exit = maze.findExitPoint();
        this.visited = new boolean[maze.getRows()][maze.getCols()];
        this.pathStack = new Stack<>();
        this.visitedPositions = new HashSet<>();
    }

    @Override
    public String solve() {
        if (entry == null || exit == null) {
            return "";
        }

        // Start DFS from entry point
        if (dfs(entry[0], entry[1])) {
            return convertStackToPath();
        }
        return "";
    }

    private boolean dfs(int row, int col) {
        // Check if we've reached the exit
        if (row == exit[0] && col == exit[1]) {
            return true;
        }

        // Mark current position as visited
        visited[row][col] = true;
        String positionKey = row + "," + col;
        visitedPositions.add(positionKey);

        // Try all possible directions
        for (Direction dir : Direction.values()) {
            int newRow = row;
            int newCol = col;

            // Calculate new position based on direction
            switch (dir) {
                case NORTH -> newRow--;
                case SOUTH -> newRow++;
                case EAST -> newCol++;
                case WEST -> newCol--;
            }

            // Check if new position is valid and not visited
            if (isValidPosition(newRow, newCol) && !visited[newRow][newCol] && 
                maze.grid[newRow][newCol] == Block.EMPTY) {
                
                pathStack.push(dir);
                if (dfs(newRow, newCol)) {
                    return true;
                }
                pathStack.pop(); // Backtrack
            }
        }

        return false;
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < maze.getRows() && col >= 0 && col < maze.getCols();
    }

    private String convertStackToPath() {
        StringBuilder path = new StringBuilder();
        for (Direction dir : pathStack) {
            switch (dir) {
                case NORTH -> path.append("F ");
                case SOUTH -> path.append("F ");
                case EAST -> path.append("F ");
                case WEST -> path.append("F ");
            }
        }
        return path.toString().trim();
    }

    @Override
    public boolean checkPath(String path) {
        String user_path = PathConverter.Canonical(path);
        int[] currentPos = Arrays.copyOf(entry, entry.length);
        Direction currentDir = Direction.EAST; // Starting direction
        
        // Reset visited positions
        visitedPositions.clear();
        visitedPositions.add(currentPos[0] + "," + currentPos[1]);

        for (int i = 0; i < user_path.length(); i++) {
            char instruction = user_path.charAt(i);
            
            try {
                switch (instruction) {
                    case 'F' -> {
                        if (!moveForward(currentPos, currentDir)) {
                            return false;
                        }
                        String newPosKey = currentPos[0] + "," + currentPos[1];
                        if (visitedPositions.contains(newPosKey)) {
                            // Detected a loop
                            return false;
                        }
                        visitedPositions.add(newPosKey);
                    }
                    case 'R' -> currentDir = turnRight(currentDir);
                    case 'L' -> currentDir = turnLeft(currentDir);
                    default -> {
                        System.out.println("Invalid instruction in path");
                        return false;
                    }
                }
            } catch (Exception e) {
                return false;
            }
        }

        return Arrays.equals(currentPos, exit);
    }

    private boolean moveForward(int[] currentPos, Direction dir) {
        int newRow = currentPos[0];
        int newCol = currentPos[1];

        switch (dir) {
            case NORTH -> newRow--;
            case SOUTH -> newRow++;
            case EAST -> newCol++;
            case WEST -> newCol--;
        }

        if (!isValidPosition(newRow, newCol) || maze.grid[newRow][newCol] == Block.WALL) {
            return false;
        }

        currentPos[0] = newRow;
        currentPos[1] = newCol;
        return true;
    }

    private Direction turnRight(Direction direction) {
        return switch (direction) {
            case WEST -> Direction.NORTH;
            case EAST -> Direction.SOUTH;
            case NORTH -> Direction.EAST;
            case SOUTH -> Direction.WEST;
        };
    }

    private Direction turnLeft(Direction direction) {
        return switch (direction) {
            case WEST -> Direction.SOUTH;
            case EAST -> Direction.NORTH;
            case NORTH -> Direction.WEST;
            case SOUTH -> Direction.EAST;
        };
    }
}
