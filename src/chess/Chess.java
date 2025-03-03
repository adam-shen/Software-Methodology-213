package chess;

public class Chess {

    private static Board board;
    private static Rules rules;
    private static Color currentPlayer;

    enum Player {
        white, black
    }

    /**
     * Plays the next move for whichever player has the turn.
     * 
     * @param move String for next move, e.g. "a2 a3"
     * 
     * @return A ReturnPlay instance that contains the result of the move.
     *         See the section "The Chess class" in the assignment description for
     *         details of
     *         the contents of the returned ReturnPlay instance.
     */
    public static ReturnPlay play(String move) {

        ReturnPlay result = new ReturnPlay();

        move = move.trim();

        // Handle resigning.
        if (move.equals("resign")) {
            result.piecesOnBoard = board.getReturnPieces();
            // If the current player resigns, the opponent wins.
            result.message = (currentPlayer == Color.WHITE)
                    ? ReturnPlay.Message.RESIGN_WHITE_WINS
                    : ReturnPlay.Message.RESIGN_BLACK_WINS;
            return result;
        }

        boolean drawRequested = move.contains("draw?");
        if (drawRequested) {
            // Remove the "draw?" part from the move string.
            move = move.replace("draw?", "").trim();
        }

        // Attempt to move the piece.
        // The movePiece method (to be implemented in Board) should:
        // - Parse the move string into source and destination positions.
        // - Validate the move using the piece's movement rules and the provided Rules
        // instance.
        // - Update the board if the move is legal.
        boolean moveExecuted = board.movePiece(move);

        // If the move is illegal, return the unchanged board state with an error
        // message.
        if (!moveExecuted) {
            result.piecesOnBoard = board.getReturnPieces();
            result.message = ReturnPlay.Message.ILLEGAL_MOVE;
            return result;
        }

        // Check game state: e.g., check, checkmate, draw, etc.
        // (Implement these methods in your Rules class as needed.)
        if (rules.isCheckmate(currentPlayer, board)) {
            // The winning message is based on which player just moved.
            result.message = (currentPlayer == Color.WHITE)
                    ? ReturnPlay.Message.CHECKMATE_WHITE_WINS
                    : ReturnPlay.Message.CHECKMATE_BLACK_WINS;
        } else if (rules.isInCheck(currentPlayer, board)) {
            result.message = ReturnPlay.Message.CHECK;
        }

        // After a successful move, if a draw was requested, override the message.
        if (drawRequested) {
            result.message = ReturnPlay.Message.DRAW;
        }

        // After a valid move, switch the turn to the other player.
        switchPlayer();

        // Update the board state in the ReturnPlay object.
        result.piecesOnBoard = board.getReturnPieces();
        return result;
    }

    /**
     * This method should reset the game, and start from scratch.
     */
    public static void start() {
        board = new Board();
        board.initialize();
        rules = new Rules();
        currentPlayer = Color.WHITE;

    }

    private static void switchPlayer() {
        currentPlayer = (currentPlayer == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }
}
