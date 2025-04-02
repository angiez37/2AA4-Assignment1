package ca.mcmaster.se2aa4.mazerunner;

import java.beans.Transient;
import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests that the maze class correctly locates the exit point of a maze using three different mazes
 */
public class MazeExitTest {
    private Maze maze;

    @Test
    public void testSmallMazeExit() throws Exception {
        File testFile = new File("./examples/small.maz.txt");
        this.maze = new Maze(testFile);
        int[] exit = this.maze.findExitPoint();
        assertNotNull(exit);
        assertEquals(Block.EMPTY, this.maze.grid[exit[0]][exit[1]]);
    }

    @Test
    public void testLargeMazeExit() throws Exception {
        File testFile = new File("./examples/large.maz.txt");
        this.maze = new Maze(testFile);
        int[] exit = this.maze.findExitPoint();
        assertNotNull(exit);
        assertEquals(Block.EMPTY, this.maze.grid[exit[0]][exit[1]]);
    }

    @Test
    public void testMediumMazeExit() throws Exception {
        File testFile = new File("./examples/medium.maz.txt");
        this.maze = new Maze(testFile);
        int[] exit = this.maze.findExitPoint();
        assertNotNull(exit);
        assertEquals(Block.EMPTY, this.maze.grid[exit[0]][exit[1]]);
    }
}
