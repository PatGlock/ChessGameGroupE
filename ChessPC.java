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

    public static int findPieceIndexW (String pieceName) {//NEED TO COME BACK TOO
        for (Piece piece : pieces { // Loop through Piece objects
            if (piece.name.equals(pieceName)) {
                return piece.getIndex(); // Return the index automatically
            }
    }

    class Piece {
        String name;
        int index;

        public Piece(String name, int row, int col) {
            this.name = name;
            this.index = (8 * row) + col; // Calculate index
        }

        public int getIndex() {// RETURN THE INDEX
            return index;
        }
       public  class ChessPC {
           public static void ChessPC(String[] args) {
               List<Piece> pieces = new ArrayList<>();
               pieces.add(new Piece("rook");
               pieces.add(new Piece("pawn");
               pieces.add(new Piece("knight");
               pieces.add(new Piece("bishop");
               pieces.add(new Piece("queen");
               pieces.add(new Piece("king");

       }
           public  void move(int direction){
               switch (direction){
                   case 1 //up
                       row +=1;
                        break;
                   case 2 //down
                       row -=1;
                        break;
                   case 3 //left
                       col -=1;
                        break;
                   case 4 //right
                       col +=;
                        break;
                        //idk if i need an invalid move tho
               }
           }
           public King (Piece) {//King movement kinda
               if (pieces[5].equals("king")) {
                   //Call the move function
           }return ("Not vaild move! Try again.")
           }
           public Queen(Piece){//Queen movement kind
               if (pieces[4].equals("queen"))
                   move()// maybe called wrong{
             }else{
               move(1);
               move(4);
           }else{
               move(1);
               move(3);
           }else{
               move(2);
               move(4);
           }else{
               move(2)
               move(3);
           }
           }
       }
}

        public abstract boolean move(int newX, int newY);// UPDATE ARRAY FOR NEW X AND Y MAYBE
