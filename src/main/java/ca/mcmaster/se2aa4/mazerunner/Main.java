package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.mazerunner.commands.*;
import ca.mcmaster.se2aa4.mazerunner.algorithms.*;

import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Path to the maze file");
        options.addOption("s", true, "Solver to be used");
        options.addOption("p", true, "Path to be validated");

        CommandLineParser parser = new DefaultParser();
        HelpFormatter formatter = new HelpFormatter();
        
        try {
            CommandLine cmd = parser.parse(options, args);

            // Check if the -i flag is provided
            if (!cmd.hasOption("i")) {
                formatter.printHelp("MazeRunner", options);
                return;
            }

            String filePath = cmd.getOptionValue("i");
            logger.trace("Reading maze from file: " + filePath);
            
            File mazeFile = new File(filePath);
            if (!mazeFile.exists()) {
                logger.error("Error: Maze file not found.");
                return;
            }

            // Create and load the maze
            Maze maze = new Maze(mazeFile);
            MazeSolver solver;
            MazeInvoker invoker = new MazeInvoker();

            // Check if the -s flag is provided
            if (cmd.hasOption("s")) {
                String solverName = cmd.getOptionValue("s");
                logger.info("Using solver: " + solverName);
                if (solverName.equals("RightHandRule")) {
                    solver = new RightHandRule(maze);
                } else if (solverName.equals("DepthFirstSearch")) {
                    solver = new DepthFirstSearch(maze);
                } else {
                    logger.error("Error: Invalid solver name.");
                    return;
                }
            } else {
                logger.info("Using default solver: RightHandRule");
                solver = new RightHandRule(maze);
            }

            SolverSelect solverSelect = new SolverSelect(solver);
 
             // If -p is provided, validate the given path instead of solving
            if (cmd.hasOption("p")) {
                String userPath = cmd.getOptionValue("p");
                logger.info("Validating user-provided path: " + userPath);

                MazeCommand command = new ValidatePathCommand(solverSelect, userPath);
                invoker.setCommand(command);
                invoker.executeCommand();

            } else {
                MazeCommand command = new SolveCommand(solverSelect);
                invoker.setCommand(command);
                invoker.executeCommand();


            }
            logger.info("** End of MazeRunner");

        } catch (ParseException e) {
            logger.error("Error parsing command line arguments.");
            formatter.printHelp("MazeRunner", options);
        } catch(Exception e) {
            logger.error("/!\\ An error has occured /!\\", e);
        }
    }
}