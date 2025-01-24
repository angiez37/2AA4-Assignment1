package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.Block;
import ca.mcmaster.se2aa4.mazerunner.MazeProcessor;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    public final Block[][] grid;
    private int rows, cols;

    public Maze(File maze_file) {
        loadMaze(maze_file);
    }
    private void loadMaze(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            rows = 0;
            while ((line = reader.readLine()) != null) {
                cols = line.length();
                rows++;
            }
        } catch (IOException e) {
            System.err.println("Error reading maze file.");
            System.exit(1);
        }

        grid = new Tile[rows][cols];

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            int row = 0;
            while ((line = reader.readLine()) != null) {
                for (int col = 0; col < cols; col++) {
                    grid[row][col] = (line.charAt(col) == '#') ? Tile.WALL : Tile.EMPTY;
                }
                row++;
            }
        } catch (IOException e) {
            System.err.println("Error loading maze data.");
            System.exit(1);
        }
    }
    public int[] findEntryPoint() {
        for (int row = 1; row < rows - 1; row++) {
            if (grid[row][0] == Tile.EMPTY) return new int[]{row, 0};  // Left border entry
            if (grid[row][cols - 1] == Tile.EMPTY) return new int[]{row, cols - 1}; // Right border entry
        }
        return null;
    }

    public int[] findExitPoint() {
        for (int row = 1; row < rows - 1; row++) {
            if (grid[row][0] == Tile.EMPTY) return new int[]{row, 0}; // Left border exit
            if (grid[row][cols - 1] == Tile.EMPTY) return new int[]{row, cols - 1}; // Right border exit
        }
        return null;
    }

    public void printMaze() {
        for (Tile[] row : grid) {
            for (Tile tile : row) {
                System.out.print(tile);
            }
            System.out.println();
        }
    }
    
}