package chess;

public class Rules {

    // Determines if castling is allowed between the given king and rook.
    // Checks:
    // They are on the same row.
    // All squares between them are empty.
    // Additional rules such as king not in check are assumed to be handled
    // elsewhere.)

    public static boolean canCastle(King king, Rook rook, Board board) {
        if (king.getPosition().getRow() != rook.getPosition().getRow()) {
            return false;
        }
        int kingCol = king.getPosition().getCol();
        int rookCol = rook.getPosition().getCol();
        int start = Math.min(kingCol, rookCol) + 1;
        int end = Math.max(kingCol, rookCol);
        for (int col = start; col < end; col++) {
            Position pos = new Position(king.getPosition().getRow(), col);
            if (!board.isEmpty(pos.getRow(), pos.getCol()))
                return false;
        }
        return true;
    }

    public static boolean canEnPassant(Pawn pawn, Pawn targetPawn, Board board) {
        return false;
    }

    public static boolean isInCheck(Color player, Board board) {
        King king = findKing(player, board);
        if (king == null)
            return false;
        for (Piece piece : board.getAllPieces()) {
            if (piece.getColor() != player) {
                if (piece.getLegalMoves(board).contains(king.getPosition())) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isCheckmate(Color player, Board board) {
        if (!isInCheck(player, board))
            return false;
        for (Piece piece : board.getAllPieces()) {
            if (piece.getColor() == player) {
                for (Position move : piece.getLegalMoves(board)) {
                    Board simulated = board.simulateMove(piece, move);
                    if (!isInCheck(player, simulated))
                        return false;
                }
            }
        }
        return true;
    }

    // Helper method
    private static King findKing(Color player, Board board) {
        for (Piece piece : board.getAllPieces()) {
            if (piece instanceof King && piece.getColor() == player) {
                return (King) piece;
            }
        }
        return null;
    }
}
