public class Piece {
    // Fields (object properties)
    private String piece;
    private int color;
    private Boolean flag;
    private int x;
    private int y;
    public static Piece empty= new Piece("empty",0,false);
    // Constructor
    public Piece(String piece, int color, Boolean flag) {
        this.piece = piece;
        this.color = color;
        this.flag = flag;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getX(){return x;}

    public void setY(int y) {
        this.y = y;
    }

    public int getY(){return y;}

    //method to determine if the piece can complete en passant/castling
    public Boolean getFlag() {
        return flag;
    }

    //method to set pawn flag to 0 after it has moved for a turn
    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public void setPiece(String piece) {
        this.piece = piece;
    }

    // method to determine what piece it is
    public String getPiece() {
        return piece;
    }

    // Setter for piece
    public void promote(String piece) {
        this.piece = piece;
    }

    // Getter for color
    public int getColor() {
        return color;
    }

    // Setter for color
    public void setColor(int color) {
        this.color = color;
    }

}


