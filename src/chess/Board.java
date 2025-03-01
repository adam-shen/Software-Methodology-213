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

        return false;
    }

}
