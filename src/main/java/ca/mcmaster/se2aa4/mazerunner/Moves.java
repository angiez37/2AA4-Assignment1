package ca.mcmaster.se2aa4.mazerunner;


public enum Moves {
    FORWARD('F'),
    LEFT('L'),
    RIGHT('R');

    private final char symbol;

    Moves(char symbol) { this.symbol = symbol; }

    @Override
    public String toString() { return "" + symbol; }
}
