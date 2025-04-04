package ca.mcmaster.se2aa4.mazerunner.commands;
import ca.mcmaster.se2aa4.mazerunner.algorithms.SolverSelect;
import ca.mcmaster.se2aa4.mazerunner.commands.MazeCommand;

public class SolveCommand implements MazeCommand {
    private SolverSelect solver;
    
    public SolveCommand(SolverSelect solver) {
        this.solver = solver;
    }
    
    public void execute() {
        String path = solver.solve();
        System.out.println("Generated path: " + path);
    }
}
