package ca.mcmaster.se2aa4.mazerunner.algorithms;

import ca.mcmaster.se2aa4.mazerunner.Block;
import ca.mcmaster.se2aa4.mazerunner.Direction;
import ca.mcmaster.se2aa4.mazerunner.Moves;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.algorithms.MazeSolver;
import ca.mcmaster.se2aa4.mazerunner.PathConverter;

import java.util.*;

public class DepthFirstSearch implements MazeSolver {
    private final Maze maze;
    private int[] entry;
    private int[] exit;
    private boolean[][] visited;
    private List<Moves> pathDirections;
    private Direction currentDirection;
    private Set<String> visitedPositions;

    public DepthFirstSearch(Maze maze) {
        this.maze = maze;
        this.entry = maze.findEntryPoint();
        this.exit = maze.findExitPoint();
        this.visited = new boolean[maze.getRows()][maze.getCols()];
        this.pathDirections = new ArrayList<>();
        this.currentDirection = Direction.EAST; // Initial facing direction
        this.visitedPositions = new HashSet<>();
    }

    @Override
    public String solve() {
        if (entry == null || exit == null) {
            return "";
        }

        // Start DFS from entry point
        if (dfs(entry[0], entry[1], currentDirection)) {
            return convertPathToInstructions();
        }
        return "";
    }

    private boolean dfs(int row, int col, Direction facing) {
        // Check if we've reached the exit
        if (row == exit[0] && col == exit[1]) {
            return true;
        }

        // Mark current position as visited
        visited[row][col] = true;

        // Try all possible directions relative to current facing
        for (Moves turn : getPossibleTurns()) {
            Direction newFacing = applyTurn(facing, turn);
            int[] newPos = getNewPosition(row, col, newFacing);

            if (isValidPosition(newPos[0], newPos[1]) && 
                !visited[newPos[0]][newPos[1]] && 
                maze.grid[newPos[0]][newPos[1]] == Block.EMPTY) {
                
                // Record the turn and move
                if (!turn.equals(Moves.FORWARD)) {
                    pathDirections.add(turn);
                }
                pathDirections.add(Moves.FORWARD);
                
                if (dfs(newPos[0], newPos[1], newFacing)) {
                    return true;
                }
                
                // Backtrack
                pathDirections.remove(pathDirections.size() - 1);
                if (!turn.equals(Moves.FORWARD)) {
                    pathDirections.remove(pathDirections.size() - 1);
                }
            }
        }

        return false;
    }

    private List<Moves> getPossibleTurns() {
        // Try forward first, then right, then left (preference order)
        return Arrays.asList(Moves.FORWARD, Moves.RIGHT, Moves.LEFT);
    }

    private Direction applyTurn(Direction current, Moves turn) {
        if (turn.equals(Moves.FORWARD)) return current;
        if (turn.equals(Moves.RIGHT)) return turnRight(current);
        if (turn.equals(Moves.LEFT)) return turnLeft(current);
        return current;
    }

    private int[] getNewPosition(int row, int col, Direction dir) {
        return switch (dir) {
            case NORTH -> new int[]{row - 1, col};
            case SOUTH -> new int[]{row + 1, col};
            case EAST -> new int[]{row, col + 1};
            case WEST -> new int[]{row, col - 1};
        };
    }

    private String convertPathToInstructions() {
        StringBuilder path = new StringBuilder();
        for (Moves move : pathDirections) {
            switch (move) {
                case FORWARD -> path.append("F ");
                case RIGHT -> path.append("R ");
                case LEFT -> path.append("L ");
            }
        }
        return path.toString().trim();
    }

    private boolean isValidPosition(int row, int col) {
        return row >= 0 && row < maze.getRows() && col >= 0 && col < maze.getCols();
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
