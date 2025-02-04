package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import java.io.FileReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.commons.cli.*;

public class Main {

    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        logger.info("** Starting Maze Runner");

        Options options = new Options();
        options.addOption("i", true, "Path to the maze file");
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
             maze.printMaze();
 
             // If -p is provided, validate the given path instead of solving
            if (cmd.hasOption("p")) {
                String userPath = cmd.getOptionValue("p");
                logger.info("Validating user-provided path: " + userPath);

                RightHandRule solver = new RightHandRule(maze);
                boolean isValid = solver.checkPath(userPath);

                if (isValid) {
                    logger.info("The provided path is VALID for the maze.");
                } else {
                    logger.error("The provided path is INVALID for the maze.");
                }
            } else {
                // Solve the maze using the Right-Hand Rule
                RightHandRule solver = new RightHandRule(maze);
                String path = solver.solve();

                // Print the solved maze
                logger.info("Solved maze: ");
                logger.info(System.lineSeparator());
                maze.printMaze();

                // Print the path
                logger.info("Generated Path: " + path);
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
