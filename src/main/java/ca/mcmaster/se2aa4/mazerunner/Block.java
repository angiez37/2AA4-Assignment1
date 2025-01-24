package ca.mcmaster.se2aa4.mazerunner;

public enum Block {
    WALL('#'),
    EMPTY(' ');
    private final char symbol;
    Block(char symbol) { this.symbol = symbol; }
    @Override
    public String toString() { return "" + symbol; }
}
