package ca.mcmaster.se2aa4.mazerunner.commands;
import ca.mcmaster.se2aa4.mazerunner.commands.MazeCommand;

public class MazeInvoker {
    private MazeCommand command;
    
    public void setCommand(MazeCommand command) {
        this.command = command;
    }
    
    public void executeCommand() {
        command.execute();
    }
}
