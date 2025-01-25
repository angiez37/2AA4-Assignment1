package ca.mcmaster.se2aa4.mazerunner;

public class MazeSolver {
    private final Maze maze;
    private Block[][] grid;
    private int row, col;

    public MazeSolver(Maze maze) {
        this.maze = maze;
        int[] entry = maze.findEntryPoint();
        if (entry != null) {
            this.row = entry[0];
            this.col = entry[1];
        }
    }

    public void solve() {

        while (col < maze.getCols() && maze.grid[row][col] != Block.WALL) {
            moveForward();
        }
    }

    private void moveForward() {
        if (maze.grid[row][col] != Block.WALL) {
            maze.grid[row][col] = Block.PATH; // Mark the path
            col++; // Move right in a straight maze
        }
    }
}
