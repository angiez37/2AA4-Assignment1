package ca.mcmaster.se2aa4.mazerunner.commands;
import ca.mcmaster.se2aa4.mazerunner.algorithms.SolverSelect;
import ca.mcmaster.se2aa4.mazerunner.commands.MazeCommand;

public class ValidatePathCommand implements MazeCommand {
    private SolverSelect solver;
    private String path;
    
    public ValidatePathCommand(SolverSelect solver, String path) {
        this.solver = solver;
        this.path = path;
    }
    
    public void execute() {
        boolean isValid = solver.checkPath(path);
        System.out.println("The provided path is " + (isValid ? "valid" : "invalid") + " for the maze.");
    }
}
