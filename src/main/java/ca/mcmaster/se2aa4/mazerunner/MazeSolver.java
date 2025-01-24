package ca.mcmaster.se2aa4.mazerunner;

public MazeSolver(Maze maze) {
    this.maze = maze;
    int[] entry = maze.findEntryPoint();
    if (entry != null) {
        this.row = entry[0];
        this.col = entry[1];
    }
}

public void solve() {
    while (col < maze.getCols() - 1 && !maze.isWall(row, col)) {
        moveForward();
    }
}

private void moveForward() {
    if (!maze.isWall(row, col)) {
        maze.setTile(row, col, Tile.PATH); // Mark the path
        col++; // Move right in a straight maze
    }
}
