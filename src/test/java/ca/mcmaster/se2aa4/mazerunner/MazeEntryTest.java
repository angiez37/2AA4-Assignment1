package ca.mcmaster.se2aa4.mazerunner;

import java.beans.Transient;
import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/*
 * Tests that the maze class correctly locates the entry point of a maze using three different mazes
 */
public class MazeEntryTest {
    private Maze maze;
    @Test
    public void testSmallMazeEntry() throws Exception {
        File testFile = new File("./examples/small.maz.txt");
        this.maze = new Maze(testFile);
        int[] entry = this.maze.findEntryPoint();
        assertNotNull(entry);
        assertEquals(Block.EMPTY, this.maze.grid[entry[0]][entry[1]]);
    }

    @Test
    public void testLargeMazeEntry() throws Exception {
        File testFile = new File("./examples/large.maz.txt");
        this.maze = new Maze(testFile);
        int[] entry = this.maze.findEntryPoint();
        assertNotNull(entry);
        assertEquals(Block.EMPTY, this.maze.grid[entry[0]][entry[1]]);
    }

    @Test
    public void testMediumMazeEntry() throws Exception {
        File testFile = new File("./examples/medium.maz.txt");
        this.maze = new Maze(testFile);
        int[] entry = this.maze.findEntryPoint();
        assertNotNull(entry);
        assertEquals(Block.EMPTY, this.maze.grid[entry[0]][entry[1]]);
    }
}
