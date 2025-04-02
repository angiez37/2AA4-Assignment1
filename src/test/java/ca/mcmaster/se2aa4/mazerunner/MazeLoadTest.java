package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


/*
 * Tests that a maze can be loaded from a file
 */
public class MazeLoadTest {
    @Test
    public void testMazeLoading() throws Exception {
        File testFile = new File("./examples/small.maz.txt");
        Maze maze = new Maze(testFile);
        assertNotNull(maze.grid);
        assertTrue(maze.getRows() > 0);
        assertTrue(maze.getCols() > 0);
    }   
}
