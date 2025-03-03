package chess;

import java.util.ArrayList;

public abstract class Piece {
    protected Color color;
    protected Position position;
    
    public Piece(Color color, Position position) {
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
}

