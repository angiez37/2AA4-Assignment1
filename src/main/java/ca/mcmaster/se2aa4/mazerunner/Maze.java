package ca.mcmaster.se2aa4.mazerunner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.MazeProcessor;

public class Maze {
    
    private static final Logger logger = LogManager.getLogger();
    public Maze(File maze_file) {
        // PARSE FILE
    }
    public MazeProcessor path() {
        MazeExplorer maze_exp = new RightHandAlgo();
        return maze_exp.find_path(this);
    }
    private int start() { return 10; }
}