package ca.mcmaster.se2aa4.mazerunner;

import java.util.logging.LogManager;
public class MazeProcessor {
    
    private final Integer length;
    private final String directions;
    public MazeProcessor(Integer length, String directions) {
        this.length = length;
        this.directions = directions;
    }
    @Override
    public String toString() { return directions; }
}
