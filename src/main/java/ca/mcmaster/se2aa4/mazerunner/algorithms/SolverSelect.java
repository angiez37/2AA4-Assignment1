package ca.mcmaster.se2aa4.mazerunner.algorithms;
import ca.mcmaster.se2aa4.mazerunner.algorithms.MazeSolver;

/*
 * Context class to select different solving algorithms (strategies) at runtime
 */

public class SolverSelect {
    private MazeSolver solver;

    public SolverSelect(MazeSolver solver) {
        this.solver = solver;
    }
    
    public String solve() {
        return solver.solve();
    }
    
    public boolean checkPath(String path) {
        return solver.checkPath(path);
    }
    
}
