package Chess;

import java.util.ArrayList;

public class Bishop extends Piece {

    public Bishop(Color color, Position position) {
        super(color, position);
    }
    
    @Override
    public ArrayList<Position> getLegalMoves(Board board) {
        ArrayList<Position> moves = new ArrayList<>();
        int[] rowDirs = {-1, -1, 1, 1};
        int[] colDirs = {-1, 1, -1, 1};
        
        for (int i = 0; i < rowDirs.length; i++) {
            int newRow = position.getRow();
            int newCol = position.getCol();
            while (true) {
                newRow += rowDirs[i];
                newCol += colDirs[i];
                Position newPos = new Position(newRow, newCol);
                if (!inBounds(newPos)) break;
                if (board.isEmpty(newPos)) {
                    moves.add(newPos);
                } else {
                    if (board.getPiece(newPos).getColor() != this.color) {
                        moves.add(newPos);
                    }
                    break;
                }
            }
        }
        return moves;
    }
    
    private boolean inBounds(Position pos) {
        return pos.getRow() >= 0 && pos.getRow() < 8 && pos.getCol() >= 0 && pos.getCol() < 8;
    }
    
    @Override
    public Piece copy() {
        return new Bishop(this.color, new Position(this.position.getRow(), this.position.getCol()));
    }
    
    @Override
    public String toString() {
        return (color == Color.WHITE) ? "wB" : "bB";
    }
}
