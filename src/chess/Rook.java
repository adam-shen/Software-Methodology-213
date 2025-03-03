package chess;

import java.util.ArrayList;

public class Rook extends Piece {

    public Rook(Position position, Color color) {
        super(position, color);
    }

    @Override
    public ArrayList<Position> getLegalMoves(Board board) {
        ArrayList<Position> moves = new ArrayList<>();
        int[] rowDirs = { -1, 0, 1, 0 };
        int[] colDirs = { 0, 1, 0, -1 };

        for (int i = 0; i < rowDirs.length; i++) {
            int newRow = position.getRow();
            int newCol = position.getCol();
            while (true) {
                newRow += rowDirs[i];
                newCol += colDirs[i];
                Position newPos = new Position(newRow, newCol);
                if (!inBounds(newPos))
                    break;
                if (board.isEmpty(newRow, newCol)) {
                    moves.add(newPos);
                } else {
                    if (board.getPiece(newRow, newCol).getColor() != this.color) {
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
        return new Rook(new Position(this.position.getRow(), this.position.getCol()), this.color);
    }

    @Override
    public String toString() {
        return (color == Color.WHITE) ? "wR" : "bR";
    }
}
