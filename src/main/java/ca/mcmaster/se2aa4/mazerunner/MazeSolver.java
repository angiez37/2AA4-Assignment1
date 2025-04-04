package ca.mcmaster.se2aa4.mazerunner;

/*
 * Maze Solver interface outlining the solve and checkPath methods to be implemented by each algorithm (strategy)
 */
public interface MazeSolver {
    String solve();
    boolean checkPath(String path);
}
