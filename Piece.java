public class Piece {
    // Fields (object properties)
    private String piece;
    private Boolean taken;
    private int color;

    // Constructor
    public Piece(String piece, Boolean taken, int color) {
        this.piece = piece;
        this.taken = taken;
        this.color = color;
    }

    // method to determine what piece it is
    public String getPiece() {
        return piece;
    }

    // Setter for make
    public void promote(String piece) {
        this.piece = piece;
    }

    // Getter for model
    public Boolean isTaken() {
        return taken;
    }

    // Setter for model
    public void takePiece() {
        this.taken = true;
    }

    // Getter for year
    public int getColor() {
        return color;
    }

    // Setter for year
    public void setColor(int color) {
        this.color = color;
    }
}

