package ca.mcmaster.se2aa4.mazerunner;

import java.io.File;
import ca.mcmaster.se2aa4.mazerunner.Maze;
import ca.mcmaster.se2aa4.mazerunner.PathConverter;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PathTest {
    @Test
    public void testPathConversion() {
        String factoredPath = "3F2R4LR1R6F";
        String expected = "FFFRRLLLLRRFFFFFF";
        assertEquals(expected, PathConverter.Canonical(factoredPath));
    }
}
