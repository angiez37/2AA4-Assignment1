package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.algorithms.DepthFirstSearch;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests that the Depth First Search algorithm correctly solves a maze and returns the correct path sequence using 3 different mazes
 */

public class DepthFirstSearchTest {
    @Test
    public void testSmallMazeSolve() throws Exception {
        File testFile = new File("./examples/small.maz.txt");
        Maze maze = new Maze(testFile);
        DepthFirstSearch solver = new DepthFirstSearch(maze);
        String path = solver.solve();
        String expectedResult = "F L F R F F L F F F F F F R F F F F R F F L F F R F F L F";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testRectangleMazeSolve() throws Exception {
        File testFile = new File("./examples/rectangle.maz.txt");
        Maze maze = new Maze(testFile);
        DepthFirstSearch solver = new DepthFirstSearch(maze);
        String path = solver.solve();
        String expectedResult = "F L F F F F F F F F F F F R F F R F F F F L F F F F F F F F L F F R F F F F L F F R F F F F F F F F F F R F F F F L F F F F F F R F F L F F F F R F F F F L F F F F F F F F F F L F F R F F F F R F L F";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testGiantMazeSolve() throws Exception {
        File testFile = new File("./examples/giant.maz.txt");
        Maze maze = new Maze(testFile);
        DepthFirstSearch solver = new DepthFirstSearch(maze);
        String path = solver.solve();
        String expectedResult = "F L F F R F F L F F F F F F R F F L F F F F F F R F F R F F L F F R F F L F F R F F F F F F F F L F F F F R F F F F L F F F F F F R F F L F F F F R F F L F F R F F F F L F F F F R F F L F F F F F F F F F F F F F F F F F F R F F F F L F F F F R F F L F F R F F L F F F F R F F F F L F F R F F L F F L F F R F F F F L F F R F F F F L F F R F F F F F F F F F F L F F F F F F R F F L F F R F F F F F F L F F R F F R F F F F L F F R F F L F F F F F F F F F F F F F F R F F F F L F F F F R F F L F F R F F F F F F F F L F F F F F F F F F F R F F L F F F F R F F L F F F F F F R F F L F F F F R F F L F F F F F F L F F R F F L F F F F R F F F F F";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }
}
