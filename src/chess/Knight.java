package chess;

import java.util.ArrayList;

public class Knight extends Piece {

    public Knight(Position position, Color color) {
        super(position, color);
    }

    @Override
    public ArrayList<Position> getLegalMoves(Board board) {
        ArrayList<Position> moves = new ArrayList<>();
        int[] rowOffsets = { -2, -1, 1, 2, 2, 1, -1, -2 };
        int[] colOffsets = { 1, 2, 2, 1, -1, -2, -2, -1 };

        for (int i = 0; i < rowOffsets.length; i++) {
            int newRow = position.getRow() + rowOffsets[i];
            int newCol = position.getCol() + colOffsets[i];
            Position newPos = new Position(newRow, newCol);
            if (inBounds(newPos)) {
                if (board.isEmpty(newRow, newCol) || board.getPiece(newRow, newCol).getColor() != this.color) {
                    moves.add(newPos);
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
        return new Knight(new Position(this.position.getRow(), this.position.getCol()), this.color);
    }

    @Override
    public String toString() {
        return (color == Color.WHITE) ? "wN" : "bN";
    }
}
