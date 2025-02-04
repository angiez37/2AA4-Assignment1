package ca.mcmaster.se2aa4.mazerunner;


public enum Direction {
    NORTH('N'),
    SOUTH('S'),
    EAST('E'),
    WEST('W');

    private final char direction;

    Direction(char direction) { this.direction = direction; }

    @Override
    public String toString() { return direction + ""; }
}