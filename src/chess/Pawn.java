package chess;

import java.util.ArrayList;

public class Pawn extends Piece {

    public Pawn(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public ArrayList<Position> getLegalMoves(Board board) {
        ArrayList<Position> moves = new ArrayList<>();
        // Assume row 0 represents rank 1 and row 7 represents rank 8.
        // White pawns move upward (increasing row), Black pawns move downward.
        int direction = (this.color == Color.WHITE) ? 1 : -1;
        int startRow = (this.color == Color.WHITE) ? 1 : 6;
        
        // Single square forward.
        Position forward = new Position(position.getRow() + direction, position.getCol());
        if (inBounds(forward) && board.isEmpty(forward)) {
            moves.add(forward);
            
            // Two squares forward from the starting row.
            Position doubleForward = new Position(position.getRow() + 2 * direction, position.getCol());
            if (position.getRow() == startRow && board.isEmpty(doubleForward)) {
                moves.add(doubleForward);
            }
        }
        
        // Diagonal captures.
        int[] diagOffsets = {-1, 1};
        for (int offset : diagOffsets) {
            Position diag = new Position(position.getRow() + direction, position.getCol() + offset);
            if (inBounds(diag) && !board.isEmpty(diag)) {
                if (board.getPiece(diag).getColor() != this.color) {
                    moves.add(diag);
                }
            }
        }
        
        // Note: En passant is handled in the Rules class.
        return moves;
    }
    
    private boolean inBounds(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8 && pos.getCol() >= 0 && pos.getCol() < 8;
    }
    
    @Override
    public Piece copy() {
        return new Pawn(this.color, new Position(this.position.getRow(), this.position.getCol()));
    }
    
    @Override
    public String toString() {
        return (color == Color.WHITE) ? "wP" : "bP";
    }
}
