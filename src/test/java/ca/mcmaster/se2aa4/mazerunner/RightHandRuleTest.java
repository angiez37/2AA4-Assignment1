package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.algorithms.RightHandRule;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests that the Right Hand Rule algorithm correctly solves a maze and returns the correct path sequence using 5 different mazes
 */
public class RightHandRuleTest {

    @Test
    public void testStraightMazeSolve() throws Exception {
        File testFile = new File("./examples/straight.maz.txt");
        Maze maze = new Maze(testFile);
        RightHandRule solver = new RightHandRule(maze);
        String path = solver.solve();
        String expectedResult = "F F F F ";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testSmallMazeSolve() throws Exception {
        File testFile = new File("./examples/small.maz.txt");
        Maze maze = new Maze(testFile);
        RightHandRule solver = new RightHandRule(maze);
        String path = solver.solve();
        String expectedResult = "F R F L L F F R F F R F F L L F F F F R F F R F F F F L L F F R F F F F R F F R F F L L F F L F F L F F F F R F F R F F L L F F F F R F F R F F L L F F R F F R F F F F R F F L F F R F F L F ";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testRegularMazeSolve() throws Exception {
        File testFile = new File("./examples/regular.maz.txt");
        Maze maze = new Maze(testFile);
        RightHandRule solver = new RightHandRule(maze);
        String path = solver.solve();
        String expectedResult = "F F F R F F R F F L L F F R F F R F F L L F F R F F R F F L L F F L F F R F F L F F L L F F R F F R F F F F F F L F F R F F F F R F F F F R F F R F F L L F F R F F L L F F F F L F F F F R F F F F F F F F R F F R F F F F F F L L F F F F R F F L F F L L F F R F F R F F F F R F F F F R F F F F F F R F F L L F F R F F R F F L L F F R F F F F F F F F R F F L L F F R F F F F F F R F F L L F F F F L L F F R F F F F F F R F F R F F F F L L F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F L F F F F L F F R F F L F F F F R F F F F F F R F F F F R F F R F F L L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F L L F F L F F F F R F F F F R F F R F F L L F F R F F R F F L L F F F F L L F F R F F R F F L L F F R F F R F F F F R F F F F L L F F F F R F F R F F L L F F L F F F F R F F L F F L L F F R F F R F F F F F F R F F R F F L L F F F F R F F R F F L F F R F F R F F L L F F L F F L F F R F F R F F L F F R F F L L F F R F F R F F F F L L F F R F F R F F L L F F R F F R F F F F R F F F F L L F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F L L F F F F R F F R F F L F F R F F R F F L L F F R F F R F F F F L L F F R F F L L F F R F F R F F L L F F F F R F F L L F F R F F L F F R F F L F F R F F L F F F F F F F F F F L F F R F F R F F F F F F R F F L L F F R F F F F F F F F R F F F F L L F F R F F R F F L L F F L F F R F F R F F F F R F F F F F F R F F F F F F R F F F F L F F F F L F F R F F F F R F F L L F F L F F R F F L L F F R F F L F F R F F F F R F F F F L F F F F F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F F F L L F F F F F F R F F R F F F F L L F F F F F F R F F R F F F F L L F F R F F R F F F F L L F F F F L F F R F F R F F L L F F R F F L L F F R F F L F F R F F F F F F R F F R F F F F L L F F F F L F F R F F F F R F F F F R F F R F F L L F F R F F F F L L F F F F F F R F F R F F L F F F F R F F R F F F F L F F F F R F F L L F F R F F R F F L L F F R F F F F F F R F F R F F L L F F L F F R F F L F F F F R F F R F F L L F F R F F F F R F F L L F F R F F R F F L L F F R F F F F L L F F R F F F F R F F R F F L L F F R F F L L F F F F L F F F F R F F F F F F R F F R F F L F F L F F L L F F R F F R F F F F L L F F R F F R F F F F L F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F F F L F F L L F F R F F F F L F F F F R F F F F F F F F R F F F F R F F R F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F L F F R F F R F F F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F R F F R F F F F L L F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F R F F L L F F F F R F F R F F F F F F F F L L F F F F R F F L L F F R F F F F R F F F F R F F R F F L L F F R F F L L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F R F F R F F F F L F F F F R F F L L F F L F F F F R F F F F R F F R F F L L F F R F F R F F L L F F L F F F F R F F L L F F R F F R F F L L F F R F F L F F R F F F F F F R F F R F F L F F R F F R F F L L F F F F F F R F F R F F F F L L F F F F R F F R F F L L F F R F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F L F F F F F F F F F F F F R F ";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testRectangleMazeSolve() throws Exception {
        File testFile = new File("./examples/rectangle.maz.txt");
        Maze maze = new Maze(testFile);
        RightHandRule solver = new RightHandRule(maze);
        String path = solver.solve();
        String expectedResult = "F R F F F F F F F L F F F F L L F F F F R F F R F F L L F F R F F F F F F F F F F F F F F F F R F F R F F F F F F F F F F F F F F L L F F F F R F F R F F F F F F L L F F F F R F F R F F F F F F L L F F R F F R F F L F F L L F F R F F L F F R F F F F R F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F F F L L F F F F F F R F F R F F F F F F L L F F F F R F F R F F F F L L F F R F F R F F L F F L L F F R F F L F F R F F L F F R F F R F F F F R F F L F F R F F L L F F R F F R F F L L F F L F F F F R F F L F F F F F F F F R F F L L F F R F F F F F F R F F R F F L L F F F F R F F F F F F R F F R F F F F L L F F R F F R F F L L F F R F F R F F F F L L F F F F L F F F F R F F R F F F F F F R F F F F L L F F F F R F F R F F F F F F L F F L L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F F F F F F F R F F L L F F F F F F L L F F F F R F F F F F F F F R F F R F F F F F F L L F F F F R F F R F F F F L L F F R F F R F F F F L F F F F F F L L F F F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F F F R F F R F F F F L L F F F F F F R F F R F F L L F F F F R F F R F F L F F R F F R F F L F F R F F L L F F L F F R F F L F F L F F R F F R F F L L F F R F F F F F F R F F F F R F F R F F L F F L L F F R F F L F F L F F R F F L L F F R F F R F F F F F F R F F F F R F F R F F L L F F L F F F F R F F R F F F F L F F R F F R F F F F L L F F R F F F F L L F F F F R F F R F F F F F F R F F F F L L F F F F R F F R F F F F L F F F F F F R F F L F F R F F F F L L F F F F R F F R F F F F F F L L F F R F F R F F F F F F L L F F R F F R F F F F L L F F R F F R F F L L F F L F F R F F L F F R F F F F R F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F F F L L F F F F F F R F F R F F F F F F F F R F F L L F F L F F F F F F R F F R F F F F F F L F F L L F F R F F R F F L L F F R F F R F F L L F F R F F L F F R F F R F F L L F F R F F R F F F F R F F F F L L F F F R F ";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }

    @Test
    public void testHugeMazeSolve() throws Exception {
        File testFile = new File("./examples/huge.maz.txt");
        Maze maze = new Maze(testFile);
        RightHandRule solver = new RightHandRule(maze);
        String path = solver.solve();
        String expectedResult = "F R F F F L F F R F F R F F L L F F R F F R F F L L F F L F F R F F L L F F R F F L F F R F F F F R F F R F F L F F F F R F F R F F L L F F R F F F F F F R F F R F F L L F F R F F F F L F F F F L L F F F F R F F F F F F R F F R F F F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F F F F F L L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F R F F R F F F F L F F R F F R F F L L F F L F F L F F R F F F F R F F R F F L F F R F F F F L L F F F F L F F R F F L F F F F F F F F F F R F F F F R F F R F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F F F L F F F F F F R F F L F F R F F F F F F L F F L L F F R F F F F F F L F F R F F R F F F F R F F F F F F L L F F F F R F F R F F F F F F L L F F R F F R F F L L F F R F F R F F L F F L L F F R F F L F F F F R F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F F F R F F R F F L F F R F F L L F F R F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F R F F R F F L L F F L F F R F F L F F F F R F F F F R F F F F R F F R F F L L F F L F F R F F R F F F F L L F F F F R F F R F F F F F F F F L L F F F F R F F R F F F F L F F L L F F R F F R F F F F R F F L L F F F F R F F R F F F F L L F F F F L F F L F F R F F F F R F F L F F R F F R F F F F R F F L L F F R F F F F F F R F F F F F F L L F F F F F F R F F R F F F F F F L F F L L F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F F F F F L L F F F F F F R F F R F F F F L L F F F F R F F R F F F F F F R F F L L F F F F L F F L L F F R F F R F F F F F F R F F R F F L F F R F F F F L L F F F F L F F R F F R F F F F R F F F F L L F F F F L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F F F L F F F F R F F L L F F L F F R F F R F F L L F F L F F R F F R F F F F R F F F F L L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F R F F R F F F F L F F R F F R F F L L F F L F F L F F R F F F F R F F R F F L L F F F F L F F L L F F R F F R F F F F F F R F F R F F L L F F F F F F R F F L L F F R F F R F F L L F F R F F L F F R F F F F F F R F F R F F L F F R F F R F F L L F F L F F R F F R F F F F R F F L L F F L F F R F F R F F F F R F F L L F F R F F R F F L F F F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F L F F L L F F R F F L F F R F F R F F F F R F F L L F F L F F R F F R F F L F F F F L L F F F F R F F R F F L L F F R F F L L F F R F F R F F L F F R F F R F F L L F F R F F F F R F F R F F L L F F F F R F F R F F F F L F F R F F R F F L L F F R F F L L F F F F L F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L F F L L F F R F F F F R F F R F F L F F R F F L L F F R F F R F F L L F F R F F L F F F F F F L L F F F F F F R F F F F F F R F F L F F R F F R F F F F R F F L F F L L F F R F F R F F L L F F F F R F F L L F F R F F R F F L L F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F F F R F F L F F R F F R F F L L F F L F F L F F R F F R F F L L F F R F F R F F F F R F F L L F F R F F L L F F F F F F R F F R F F F F F F L L F F F F F F R F F F F R F F R F F L F F F F L L F F F F R F F R F F L F F R F F F F R F F R F F L L F F R F F L L F F R F F R F F L L F F L F F R F F R F F L L F F R F F L L F F R F F R F F F F R F F L F F R F F F F R F F F F R F F R F F L L F F L F F R F F L L F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F F F F F F F R F F R F F F F L F F R F F R F F L L F F R F F F F L L F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F R F F L L F F F F F F R F F R F F F F L F F R F F R F F L L F F L F F R F F R F F F F R F F L L F F R F F R F F L L F F L F F F F F F L F F F F R F F F F R F F R F F L L F F R F F L F F L L F F R F F R F F F F L L F F F F R F F F F F F R F F R F F L L F F F F R F F L F F R F F F F F F R F F R F F L F F R F F R F F L L F F L F F R F F L L F F F F R F F R F F F F L L F F F F F F R F F R F F L L F F R F F R F F F F R F F L L F F L F F R F F L L F F R F F R F F L F F R F F F F R F F R F F L L F F L F F R F F F F F F F F R F F R F F F F F F L L F F F F R F F R F F F F L F F R F F R F F L F F L L F F R F F L F F R F F L F F L L F F R F F R F F L L F F R F F R F F F F R F F L L F F F F R F F R F F L L F F R F F F F F F F F F F R F F R F F F F F F L L F F F F F F R F F R F F F F F F L L F F F F F F R F F F F R F F R F F L L F F F F R F F R F F F F L L F F F F R F F R F F L L F F R F F R F F F F R F F L L F F R F F F F L L F F F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F F F R F F F F L L F F F F R F F R F F L L F F R F F R F F L F F R F F L L F F R F F R F F F F L F F L L F F R F F F F R F F R F F L F F L L F F R F F L F F R F F L L F F R F F F F R F F R F F L F F R F F F F R F F L L F F R F F R F F F F L F F R F F L L F F L F F R F F F F R F F R F F L F F R F F L L F F L F F R F F R F F F F R F F F F L L F F F F F F R F F R F F F F F F L F F R F F R F F L L F F R F F L L F F F F R F F L L F F F F R F F F F F F R F F R F F L L F F R F F L F F R F F F F R F F R F F L L F F R F F L L F F F F R F F R F F L L F F R F F R F F L L F F R F F R F F L F F L L F F R F F L F F R F F R F F L F F R F F R F F F F L L F F F F R F F R F F F F F F L L F F F F R F F R F F L L F F L F F R F F R F F F F L L F F R F F L L F F R F F F F F F R F F L L F F F F R F F R F F L L F F R F F L L F F R F F R F F F F F F R F F L L F F R F F L F F R F F F F R F F R F F L L F F L F F R F F L F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F F F F F L L F F F F F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F L L F F F F F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F F F R F F F F L L F F R F F R F F L L F F L F F R F F L F F R F F F F R F F R F F L L F F R F F R F F F F L L F F R F F R F F F F L L F F R F F F F R F F R F F L F F R F F L L F F L F F R F F L F F R F F F F R F F R F F L L F F R F F R F F F F L F F R F F L L F F L F F R F F R F F F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F L F F R F F R F F L L F F R F F L F F F F L L F F F F R F F R F F L L F F R F F L F F R F F R F F L F F R F F F F R F F R F F L F F L L F F R F F R F F F F L L F F F F R F F R F F F F F F F F L L F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F L F F F F R F F R F F F F F F R F F L L F F R F F R F F L F F R F F R F F L L F F L F F L F F R F F R F F F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F F F L L F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F F F L L F F F F L F F R F F R F F F F R F F F F F F L F F R F F L L F F L F F R F F R F F F F R F F F F L L F F F F L F F F F R F F R F F F F F F R F F F F L L F F F F F F F F F F L F F L F F L L F F R F F R F F F F F F R F F R F F L L F F R F F F F R F F R F F L L F F F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F F F L F F L L F F R F F F F R F F R F F L L F F R F F F F L L F F F F F F R F F L F F L L F F R F F R F F F F L F F F F R F F L F F L L F F R F F R F F F F R F F F F R F F F F F F R F F L L F F L F F F F R F F L L F F R F F R F F F F F F F F R F F F F R F F R F F L F F L L F F R F F L F F L F F F F R F F F F F F F F R F F R F F F F F F L L F F F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F F F F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F R F F R F F L L F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F L F F R F F R F F L L F F R F F L L F F F F L F F R F F F F F F R F F R F F F F L L F F F F F F L L F F R F F R F F F F R F F F F F F R F F R F F L L F F L F F R F F R F F F F R F F L F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F L F F L L F F R F F R F F F F R F F L L F F R F F R F F L F F F F R F F L L F F R F F R F F L L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F F F L L F F R F F L F F R F F L L F F R F F R F F F F F F R F F F F R F F R F F L L F F L F F L F F R F F F F F F R F F F F R F F R F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F L F F F F F F L L F F R F F R F F L F F R F F R F F L L F F L F F R F F R F F F F R F F L L F F R F F R F F L F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F F F R F F R F F L L F F R F F L L F F F F R F F R F F F F F F R F F L F F R F F R F F F F L L F F F F L F F R F F R F F F F F F L L F F R F F R F F F F L L F F F F R F F R F F L L F F R F F L L F F F F F F R F F R F F F F L L F F F F R F F R F F L F F R F F R F F L F F R F F L L F F L F F R F F L F F R F F L L F F R F F L L F F R F F R F F F F R F F F F F F R F F R F F L L F F R F F F F R F F L F F R F F L L F F L F F R F F F F R F F R F F L L F F F F L L F F R F F L F F R F F F F F F R F F R F F F F L L F F R F F R F F L L F F R F F R F F L F F R F F R F F F F L L F F F F R F F R F F L L F F L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F L F F F F F F L L F F F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F F F R F F F F L L F F F F R F F F F R F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F F F L L F F R F F L F F R F F F F R F F F F R F F R F F L L F F F F R F F R F F L L F F L F F R F F R F F F F R F F L L F F L F F R F F R F F L F F L L F F R F F R F F L L F F F F R F F R F F F F L L F F F F R F F L L F F R F F R F F L L F F R F F R F F F F L L F F R F F R F F F F R F F L L F F R F F L L F F F F F F R F F R F F L F F L L F F R F F R F F F F F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F R F F R F F F F R F F L L F F R F F L L F F R F F L L F F R F F F F R F F F F R F F R F F L L F F F F R F F R F F L L F F L F F R F F R F F L F F F F F F F F R F F R F F L F F R F F R F F L L F F L F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L F F L L F F R F F R F F L L F F F F R F F R F F F F L L F F R F F F F R F F R F F L L F F L F F L F F R F F L L F F R F F R F F L F F R F F R F F L L F F F F R F F R F F F F F F R F F L L F F L F F R F F L L F F R F F F F R F F L L F F R F F L L F F R F F R F F F F R F F F F R F F L F F L L F F R F F R F F F F L L F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F L F F R F F F F L F F R F F R F F F F R F F F F L L F F F F F F F F L L F F R F F L L F F R F F R F F F F F F R F F L L F F R F F F F R F F F F L L F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F F F F F R F F L L F F R F F L F F F F R F F F F L L F F R F F R F F F F F F R F F R F F L L F F R F F R F F F F L L F F R F F R F F F F R F F L L F F L F F R F F R F F F F L L F F F F L F F R F F L F F R F F L F F F F R F F F F R F F R F F L L F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F F F F F R F F L L F F F F R F F R F F L L F F R F F L L F F R F F L L F F R F F R F F F F R F F F F F F R F F R F F L L F F F F F F F F F F R F F L L F F L F F F F R F F R F F L L F F L F F R F F F F R F F R F F L F F R F F F F F F F F L L F F F F F F R F F L F F L L F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F R F F F F L F F F F F F R F F R F F L L F F R F F F F R F F R F F L F F L L F F R F F F F L L F F R F F F F R F F L F F L L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F F F R F F F F R F F R F F L L F F L F F R F F L L F F F F R F F R F F L F F F F R F F L L F F F F F F R F F R F F F F L L F F R F F R F F F F F F R F F R F F L L F F L F F R F F F F F F R F F R F F F F L L F F R F F L L F F R F F R F F F F R F F F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F L F F R F F L L F F F F R F F R F F F F L L F F F F R F F F F R F F R F F L L F F L F F R F F L L F F R F F F F F F R F F R F F F F L F F L L F F R F F F F R F F R F F L L F F F F R F F L F F F F R F F R F F F F F F R F F L L F F R F F R F F L L F F F F R F F R F F F F L L F F R F F F F R F F R F F L F F L L F F R F F F F R F F R F F L F F L L F F R F F R F F F F F F L L F F F F R F F R F F F F F F F F L L F F F F F F F F F F F F L L F F F F R F F R F F F F F F R F F F F F F R F F R F F L L F F R F F F F R F F R F F L L F F L F F R F F R F F L L F F R F F R F F L F F F F F F R F F L L F F R F F L L F F F F R F F F F R F F R F F L L F F R F F R F F L L F F L F F F F R F F R F F F F L L F F R F F R F F F F L L F F F F R F F F F F F R F F R F F F F L L F F F F L F F R F F R F F F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F L F F R F F L L F F L F F R F F L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F R F F L L F F F F R F F R F F L L F F R F F R F F L L F F R F F F F F F R F F L L F F F F R F F R F F F F L L F F R F F L L F F R F F L F F L F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F F F L L F F F F F F F F R F F R F F F F F F L L F F F F F F R F F R F F F F F F F F R F F L L F F R F F L L F F F F R F F R F F L L F F L F F R F F F F F F R F F R F F L F F R F F R F F L L F F R F F L L F F R F F R F F F F R F F L L F F R F F R F F F F L L F F R F F R F F L L F F R F F L L F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F F F L L F F R F F R F F F F R F F L L F F R F F L F F R F F L L F F R F F R F F L L F F L F F F F R F F F F F F R F F R F F F F L L F F R F F R F F L F F R F F F F L F F R F F L L F F L F F R F F F F F F R F F R F F F F L L F F R F F L L F F R F F R F F L L F F R F F L L F F R F F R F F F F L L F F F F F F R F F R F F L F F R F F L F F F F R F F F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F L L F F F F L F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F F F F F R F F L F F R F F L L F F L F F R F F L F F F F F F R F F L L F F R F F R F F L L F F L F F R F F R F F F F R F F F F F F R F F L L F F F F R F F R F F F F L F F L F F L L F F R F F R F F F F F F R F F R F F L L F F R F F R F F L L F F R F F L L F F F F R F F R F F F F L L F F R F F L L F F R F F R F F F F F F R F F L L F F R F F F F R F F F F F F R F F R F F F F L L F F R F F F F R F F L L F F R F F L F F L L F F R F F R F F F F L L F F R F F R F F L L F F L F F R F F R F F F F R F F F F F F R F F L L F F R F F L L F F F F R F F L L F F R F F R F F F F R F F F F R F F L F F F F L L F F F F R F F R F F F F F F R F F F F R F F L F F R F F L L F F R F F L L F F F F R F F L F F F F L F F R F F R F F F F F F R F F R F F L L F F L F F R F F L L F F R F F R F F L L F F R F F R F F L L F F R F F R F F F F L L F F R F F L L F F R F F R F F F F R F F L F F F F F F R F F F F R F F R F F L L F F F F R F F R F F F F L L F F R F F F F R F F R F F L L F F L F F R F F L L F F F F R F F L L F F R F F R F F L F F R F F R F F L L F F R F F F F R F F R F F L L F F R F F R F F F F L F F F F F F R F F R F F F F L L F F F F R F F L L F F R F F R F F L L F F L F F R F F L F F F F F F R F F F F R F F R F F L L F F R F F R F F L F F L L F F R F F L F F F F R F F L F F L L F F R F F R F F F F R F F L F F F F F F R F F L L F F F F R F F R F F F F F F L L F F F F R F F R F F F F F F L L F F F F F F R F F R F F F F F F L L F F F F R F F L F F R F F R F F L L F F R F F F F F F R F F L F F R F F L F F R F F L L F F R F F R F F F F R F F L F F L L F F R F F R F F F F F F R F F R F F L L F F R F F F F R F F R F F L F F L L F F R F F R F F F F R F F L L F F L F F R F F R F F F F R F F F F L L F F F F R F F R F F L L F F R F F L L F F R F F R F F L L F F L F F R F F F F F F L F F R F F F F R F F F F R F F R F F L L F F R F F F F F F L L F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F L F F F F R F F L L F F F F R F F R F F L L F F F F R F F R F F F F L L F F F F R F F R F F L L F F F F R F F F F L L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F R F F L L F F R F F R F F F F F F R F F L L F F R F F R F F L F F R F F F F F F R F F R F F F F L L F F F F F F R F F R F F L F F R F F R F F L F F L L F F R F F F F R F F R F F L F F L L F F R F F L F F R F F F F L L F F F F F F R F F R F F L L F F F F R F F R F F F F L L F F F F F F R F F R F F F F L F F R F F R F F L L F F R F F R F F L L F F R F F R F F F F R F F L F F L L F F R F F L F F R F F F F R F F R F F L F F R F F L L F F L F F R F F R F F F F R F F L L F F R F F F F L L F F F F F F F F F F R F F R F F F F F F F F F F L L F F F F F F R F F R F F L F F R F F R F F L F F F F L L F F F F R F F R F F F F F F F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F L F F R F F L F F R F F L L F F R F F R F F L L F F L F F R F F L L F F R F F R F F L F F R F F F F R F F R F F L L F F L F F R F F L F F R F F L L F F R F F R F F F F F F F F R F F F F R F F R F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F L L F F R F F R F F F F F F L L F F F F R F F R F F L F F L L F F R F F R F F L L F F F F R F F R F F L L F F R F F L L F F R F F R F F F F L F F R F F R F F F F L F F R F F R F F F F R F F L L F F R F F L L F F F F R F F R F F L L F F R F F R F F F F R F F L F F L L F F R F F R F F F F F F F F R F F F F L L F F F F L F F R F F R F F F F R F F F F F F L L F F F F R F F R F F L F F L L F F R F F R F F L L F F F F R F F F F R F F R F F L L F F F F R F F R F F F F L L F F F F R F F R F F L L F F F F L L F F R F F R F F L L F F R F F L F F R F F R F F F F R F F L F F R F F F F F F R F F L L F F L F F R F F R F F F F R F F L L F F R F F R F F L L F F R F F F F F F R F F F F L L F F F F L F F F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L F F L L F F R F F R F F F F L L F F F F F F R F F R F F F F L F F R F F R F F L F F R F F L L F F L F F R F F R F F F F L L F F F F F F R F F R F F L F F F F R F F R F F F F L L F F F F R F F R F F F F L L F F R F F F F R F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F L L F F F F F F R F F R F F F F L L F F R F F R F F F F R F F L L F F R F F L L F F F F F F R F F F F R F F R F F L F F F F F F L L F F R F F R F F L L F F L F F R F F F F R F F F F R F F R F F L L F F R F F F F F F F F F F L L F F R F F R F F F F L L F F F F L F F R F F F F R F F F F R F F R F F L L F F R F F F F F F L L F F F F F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F R F F L L F F R F F L L F F F F F F R F F R F F L F F R F F R F F L L F F R F F R F F L L F F R F F R F F L L F F R F F R F F L F F L L F F R F F F F R F F R F F L L F F R F F R F F L L F F R F F F F F F R F F L L F F R F F R F F L L F F L F F F F F F R F F F F R F F R F F L L F F R F F L F F R F F F F L L F F F F R F F R F F F F L F F R F F L L F F R F F R F F L L F F F F L L F F R F F F F R F F F F L F F F F R F F F F L F F F F R F F F F F F L F F R F F F F R F F F F F F R F F R F F F F L L F F F F R F F R F F L L F F R F F R F F L F F L L F F R F F R F F L F F R F F F F L L F F F F L F F R F F F F R F F F F R F F R F F L L F F R F F F F L F F R F F R F F L L F F R F F F F L L F F F F F F R F F R F F F F L L F F F R F ";
        assertNotNull(path);
        assertFalse(path.isEmpty());
        assertEquals(expectedResult, path);
    }
    
}
