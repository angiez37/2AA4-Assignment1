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

    public Maze(File maze_file) {
        // PARSE FILE
    }
    public MazeProcessor path() {
        MazeExplorer maze_exp = new RightHandAlgo();
        return maze_exp.find_path(this);
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

    
}