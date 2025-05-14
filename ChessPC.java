import java.util.ArrayList;
import java.util.List;

public class ChessPC {
    static List<Piece> Wpieces = new ArrayList<>(); // White Pieces
    static List<Piece> Bpieces = new ArrayList<>(); // Black Pieces

    // Nested Piece class
    static class Piece {
        String name;
        int row, col;
        String imagePath; // Store the image file path

        // Constructor to initialize piece with name, position, and image file
        public Piece(String name, int row, int col, String imageFileName) {
            this.name = name;
            this.row = row;
            this.col = col;
            this.imagePath = "images/" + imageFileName; // Store image path
        }

        // Method to return image path
        public String getImagePath() {
            return imagePath;
        }

        // Method to return board index
        public int getIndex() {
            return (8 * row) + col;
        }

        // Method for King movement
        public boolean moveKing(int newRow, int newCol) {
            if (Math.abs(newRow - row) <= 1 && Math.abs(newCol - col) <= 1) {
                row = newRow;
                col = newCol;
                return true;
            }
            return false;
        }
    }

    // Method to check if King is in check
    public static boolean isKingInCheck(Piece king, List<Piece> opponents) {
        for (Piece piece : opponents) {
            if (piece.name.contains("rook") && (piece.row == king.row || piece.col == king.col)) {
                return true; // Rook attack
            }
            if (piece.name.contains("bishop") && Math.abs(piece.row - king.row) == Math.abs(piece.col - king.col)) {
                return true; // Bishop attack
            }
            if (piece.name.contains("queen") && (piece.row == king.row || piece.col == king.col ||
                    Math.abs(piece.row - king.row) == Math.abs(piece.col - king.col))) {
                return true; // Queen attack
            }
            if (piece.name.contains("knight") && (Math.abs(piece.row - king.row) == 2 && Math.abs(piece.col - king.col) == 1 ||
                    Math.abs(piece.row - king.row) == 1 && Math.abs(piece.col - king.col) == 2)) {
                return true; // Knight attack
            }
        }
        return false;
    }

    // Method to check if King is in checkmate
    public static boolean isCheckmate(Piece king, List<Piece> opponents) {
        if (!isKingInCheck(king, opponents)) {
            return false; // King is not in check, so no checkmate
        }

        // Try all possible moves for the King
        for (int dr = -1; dr <= 1; dr++) {
            for (int dc = -1; dc <= 1; dc++) {
                int newRow = king.row + dr;
                int newCol = king.col + dc;

                // Ensure move is inside board and not under threat
                if (newRow >= 0 && newRow < 8 && newCol >= 0 && newCol < 8) {
                    Piece tempKing = new Piece(king.name, newRow, newCol, king.imagePath);
                    if (!isKingInCheck(tempKing, opponents)) {
                        return false; // The king can escape
                    }
                }
            }
        }

        return true; // No valid moves left, checkmate
    }

    // Static block initializes white pieces 
    static {
        Wpieces.add(new Piece("pawn1", 1, 0, "PawnW.png"));
        Wpieces.add(new Piece("pawn2", 1, 1, "PawnW.png"));
        Wpieces.add(new Piece("pawn3", 1, 2, "PawnW.png"));
        Wpieces.add(new Piece("pawn4", 1, 3, "PawnW.png"));
        Wpieces.add(new Piece("pawn5", 1, 4, "PawnW.png"));
        Wpieces.add(new Piece("pawn6", 1, 5, "PawnW.png"));
        Wpieces.add(new Piece("pawn7", 1, 6, "PawnW.png"));
        Wpieces.add(new Piece("pawn8", 1, 7, "PawnW.png"));
        Wpieces.add(new Piece("rook1", 0, 0, "RookW.png"));
        Wpieces.add(new Piece("rook2", 0, 7, "RookW.png"));
        Wpieces.add(new Piece("knight1", 0, 1, "KnightW.png"));
        Wpieces.add(new Piece("knight2", 0, 6, "KnightW.png"));
        Wpieces.add(new Piece("bishop1", 0, 2, "BishopW.png"));
        Wpieces.add(new Piece("bishop2", 0, 5, "BishopW.png"));
        Wpieces.add(new Piece("queen", 0, 3, "QueenW.png"));
        Wpieces.add(new Piece("king", 0, 4, "KingW.png"));    
    }

    // Static block initializes black pieces 
    static {
        Bpieces.add(new Piece("pawn1", 6, 0, "PawnB.png"));
        Bpieces.add(new Piece("pawn2", 6, 1, "PawnB.png"));
        Bpieces.add(new Piece("pawn3", 6, 2, "PawnB.png"));
        Bpieces.add(new Piece("pawn4", 6, 3, "PawnB.png"));
        Bpieces.add(new Piece("pawn5", 6, 4, "PawnB.png"));
        Bpieces.add(new Piece("pawn6", 6, 5, "PawnB.png"));
        Bpieces.add(new Piece("pawn7", 6, 6, "PawnB.png"));
        Bpieces.add(new Piece("pawn8", 6, 7, "PawnB.png"));
        Bpieces.add(new Piece("rook1", 7, 0, "RookB.png"));
        Bpieces.add(new Piece("rook2", 7, 7, "RookB.png"));
        Bpieces.add(new Piece("knight1", 7, 1, "KnightB.png"));
        Bpieces.add(new Piece("knight2", 7, 6, "KnightB.png"));
        Bpieces.add(new Piece("bishop1", 7, 2, "BishopB.png"));
        Bpieces.add(new Piece("bishop2", 7, 5, "BishopB.png"));
        Bpieces.add(new Piece("queen", 7, 3, "QueenB.png")); 
        Bpieces.add(new Piece("king", 7, 4, "KingB.png"));    
    }

    // Method to display all pieces with positions
    public static void displayPieces() {
        System.out.println("White Pieces:");
        for (Piece p : Wpieces) {
            System.out.println(p.name + " at index: " + p.getIndex() + " (" + p.row + "," + p.col + ") | Image Path: " + p.getImagePath());
        }

        System.out.println("\nBlack Pieces:");
        for (Piece p : Bpieces) {
            System.out.println(p.name + " at index: " + p.getIndex() + " (" + p.row + "," + p.col + ") | Image Path: " + p.getImagePath());
        }
    }
}
