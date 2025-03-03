package chess;

import java.util.ArrayList;

public class King extends Piece {

    public King(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public ArrayList<Position> getLegalMoves(Board board) {
        ArrayList<Position> moves = new ArrayList<>();
        int[] rowOffsets = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colOffsets = {-1, 0, 1, -1, 1, -1, 0, 1};
        
        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = position.getRow() + rowOffsets[i];
            int newCol = position.getCol() + colOffsets[i];
            Position newPos = new Position(newRow, newCol);
            if (inBounds(newPos)) {
                // The king can move if the target is empty or holds an enemy piece.
                if (board.isEmpty(newPos) || board.getPiece(newPos).getColor() != this.color) {
                    moves.add(newPos);
                }
            }
        }
        // Note: Castling is handled in the Rules class.
        return moves;
    }
    
    private boolean inBounds(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8 && pos.getCol() >= 0 && pos.getCol() < 8;
    }
    
    @Override
    public Piece copy() {
        return new King(this.color, new Position(this.position.getRow(), this.position.getCol()));
    }
    
    @Override
    public String toString() {
        return (color == Color.WHITE) ? "wK" : "bK";
    }
}
