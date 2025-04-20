import java.util.ArrayList;
import java.util.List;

public abstract class ChessPC {
    static List<Piece> Wpieces = new ArrayList<>(); // Store Piece objects instead of Strings

    static { // Static block initializes white pieces
        Wpieces.add(new Piece("pawn1", 1, 0));
        Wpieces.add(new Piece("pawn2", 1, 1));
        Wpieces.add(new Piece("pawn3", 1, 2));
        Wpieces.add(new Piece("pawn4", 1, 3));
        Wpieces.add(new Piece("pawn5", 1, 4));
        Wpieces.add(new Piece("pawn6", 1, 5));
        Wpieces.add(new Piece("pawn7", 1, 6));
        Wpieces.add(new Piece("pawn8", 1, 7));
        Wpieces.add(new Piece("rook1", 0, 0));
        Wpieces.add(new Piece("rook2", 0, 7));
        Wpieces.add(new Piece("knight1", 0, 1));
        Wpieces.add(new Piece("knight2", 0, 6));
        Wpieces.add(new Piece("bishop1", 0, 2));
        Wpieces.add(new Piece("bishop2", 0, 5));
        Wpieces.add(new Piece("queen", 0, 3));
        Wpieces.add(new Piece("king", 0, 4));
    }

    static List<Piece> Bpieces = new ArrayList<>(); // Store Piece objects instead of Strings

    static { // Static block initializes black pieces
        Bpieces.add(new Piece("pawn1", 6, 0));
        Bpieces.add(new Piece("pawn2", 6, 1));
        Bpieces.add(new Piece("pawn3", 6, 2));
        Bpieces.add(new Piece("pawn4", 6, 3));
        Bpieces.add(new Piece("pawn5", 6, 4));
        Bpieces.add(new Piece("pawn6", 6, 5));
        Bpieces.add(new Piece("pawn7", 6, 6));
        Bpieces.add(new Piece("pawn8", 6, 7));
        Bpieces.add(new Piece("rook1", 7, 0));
        Bpieces.add(new Piece("rook2", 7, 7));
        Bpieces.add(new Piece("knight1", 7, 1));
        Bpieces.add(new Piece("knight2", 7, 6));
        Bpieces.add(new Piece("bishop1", 7, 2));
        Bpieces.add(new Piece("bishop2", 7, 5));
        Bpieces.add(new Piece("queen", 7, 3));
        Bpieces.add(new Piece("king", 7, 4));
    }

    public static int findPieceIndexW (String pieceName) {
        for (Piece piece : Wpieces) ||((Piece piece:
        Bpieces)){ // Loop through Piece objects
            if (piece.name.equals(pieceName)) {
                return piece.getIndex(); // Return the index automatically
            }

        }
        return -1; // If not found
    }

class Piece {
    String name;
    int index;

    public Piece(String name, int row, int col) {
        this.name = name;
        this.index = (8 * row) + col; // Calculate index
    }

    public int getIndex() {
        return index;
    }

    @Override
    public String toString() {
        return name + " at index " + index;
    }
}