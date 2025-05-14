public class Main {
    public static void main(String[] args) {
        ChessBoardDisplay board = new ChessBoardDisplay(); // Create chess board

        // Step 1: Place all white pieces with their correct image paths
        for (ChessPC.Piece piece : ChessPC.Wpieces) {
            board.addPiece(piece.getIndex() / 8, piece.getIndex() % 8, piece.getImagePath());
        }

        // Step 2: Place all black pieces with their correct image paths
        for (ChessPC.Piece piece : ChessPC.Bpieces) {
            board.addPiece(piece.getIndex() / 8, piece.getIndex() % 8, piece.getImagePath());
        }

        // Step 3: Test output in console
        ChessPC.displayPieces(); // Print all piece positions and linked images
    }
}
