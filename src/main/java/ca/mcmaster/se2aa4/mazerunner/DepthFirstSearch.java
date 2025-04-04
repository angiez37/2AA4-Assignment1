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
        return null;
    }

   

    @Override
    public boolean checkPath(String path) {
        return false;
    }
}
