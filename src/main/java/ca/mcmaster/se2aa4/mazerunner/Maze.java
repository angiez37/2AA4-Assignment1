package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;


public class Maze {
    
    public Block[][] grid;
    private int rows, cols;

    public Maze(File maze_file) {
        loadMaze(maze_file);
    }
    private void loadMaze(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            java.util.List<String> lines = new java.util.ArrayList<>();
    
            while ((line = reader.readLine()) != null) {
                if (line.isEmpty()) continue;  // Skip empty lines
                lines.add(line);
            }
    
            rows = lines.size();
            cols = (rows > 0) ? lines.get(0).length() : 0;
    
            if (rows == 0 || cols == 0) {
                System.err.println("Error: Maze file is empty or invalid.");
                System.exit(1);
            }
    
            grid = new Block[rows][cols];
            System.out.println("Maze initialized with size: " + rows + " x " + cols);
    
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    grid[row][col] = (lines.get(row).charAt(col) == '#') ? Block.WALL : Block.EMPTY;
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading maze file.");
            System.exit(1);
        }
    }

    public int[] findEntryPoint() {
        for (int row = 1; row < rows - 1; row++) {
            if (grid[row][0] == Block.EMPTY) return new int[]{row, 0};  // Left border entry
            //if (grid[row][cols - 1] == Block.EMPTY) return new int[]{row, cols - 1}; // Right border entry
        }
        return null;
    }

    public int[] findExitPoint() {
        for (int row = 1; row < rows - 1; row++) {
            //if (grid[row][0] == Block.EMPTY) return new int[]{row, 0}; // Left border exit
            if (grid[row][cols - 1] == Block.EMPTY) return new int[]{row, cols - 1}; // Right border exit
        }
        return null;
    }

    public int getRows() { return rows; }
    public int getCols() { return cols; }

    public void printMaze() {
        for (Block[] row : grid) {
            for (Block block : row) {
                System.out.print(block);
            }
            System.out.println();
        }
    }
    
}