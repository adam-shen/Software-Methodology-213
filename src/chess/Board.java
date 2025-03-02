package chess;

public class Board {

    private Piece[][] grid = new Piece[8][8];
    private Color currentPlayer;

    public Board() {
        currentPlayer = Color.WHITE;
    }

    // public void initialize() { Uncomment out when Neer adds Piece class w
    // subclasses
    // grid = new Piece[8][8]; // Reset j in case

    // // Black Pieces
    // grid[0][0] = new Rook(new Position(0, 0), Color.BLACK);
    // grid[0][1] = new Knight(new Position(0, 1), Color.BLACK);
    // grid[0][2] = new Bishop(new Position(0, 2), Color.BLACK);
    // grid[0][3] = new Queen(new Position(0, 3), Color.BLACK);
    // grid[0][4] = new King(new Position(0, 4), Color.BLACK);
    // grid[0][5] = new Bishop(new Position(0, 5), Color.BLACK);
    // grid[0][6] = new Knight(new Position(0, 6), Color.BLACK);
    // grid[0][7] = new Rook(new Position(0, 7), Color.BLACK);

    // // Black Pawns
    // for (int i = 0; i < 8; i++) {
    // grid[1][i] = new Pawn(new Position(1, i), Color.BLACK);
    // }

    // // White Pieces
    // grid[7][0] = new Rook(new Position(7, 0), Color.WHITE);
    // grid[7][1] = new Knight(new Position(7, 1), Color.WHITE);
    // grid[7][2] = new Bishop(new Position(7, 2), Color.WHITE);
    // grid[7][3] = new Queen(new Position(7, 3), Color.WHITE);
    // grid[7][4] = new King(new Position(7, 4), Color.WHITE);
    // grid[7][5] = new Bishop(new Position(7, 5), Color.WHITE);
    // grid[7][6] = new Knight(new Position(7, 6), Color.WHITE);
    // grid[7][7] = new Rook(new Position(7, 7), Color.WHITE);

    // // White Pawns
    // for (int i = 0; i < 8; i++) {
    // grid[6][i] = new Pawn(new Position(6, i), Color.WHITE);
    // }

    // }

    public boolean movePiece(String move) { // Add this to parameter when Neer makes it , Rules rule

        String parts[] = move.split(" "); // Assume move is something like "e2 e4"

        if (parts.length != 2) {
            return false; // Invalid move format
        }

        String src = parts[0];
        String dest = parts[1];

        int srcCol = (src.charAt(0) - 'a');
        int srcRow = (src.charAt(1) - '0');
        int destCol = (dest.charAt(0) - 'a');
        int destRow = (dest.charAt(1) - '0');

        Piece piece = grid[srcRow][srcCol];

        if (piece == null) {
            // No piece at source.
            return false;
        }

        if (piece.getColor() != currentPlayer) {
            return false; // Not this player's turn
        }

        // Validate move with piece's own logic, board, and additional rules
        if (!piece.isValidMove(dest, this)) { // Add rules to parameter when ....
            return false;
        }

        if (grid[destRow][destCol] != null && grid[destRow][destCol].getColor() == piece.getColor()) {
            return false; // Can't capture your own piece
        }

        grid[destRow][destCol] = piece;
        grid[srcRow][srcCol] = null;
        // piece.setPosition(dest); Not sure how Neer's implementing but yeah could do
        // this

        // After successful move
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;

        return true;
    }

}
