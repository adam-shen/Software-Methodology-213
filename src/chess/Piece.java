package chess;

import java.util.ArrayList;

public abstract class Piece implements Cloneable {
    protected Color color;
    protected Position position;

    public Piece(Position position, Color color) {
        this.color = color;
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position pos) {
        this.position = pos;
    }

    public abstract ArrayList<Position> getLegalMoves(Board board);

    public abstract Piece copy();

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
