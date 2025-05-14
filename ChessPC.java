import java.util.ArrayList;
import java.util.List;

public class ChessPC {
    static List<Piece> Wpieces = new ArrayList<>(); // White Pieces
    static List<Piece> Bpieces = new ArrayList<>(); // Black Pieces

    static class Piece {
        String name;
        int index;
        String imagePath; // Store the image file path

        // Constructor to initialize piece with name, position, and image file
        public Piece(String name, int row, int col, String imageFileName) {
            this.name = name;
            this.index = (8 * row) + col; // Calculate board index
            this.imagePath = "images/" + imageFileName; // Store image path
        }

        // Method to return the index
        public int getIndex() {
            return index;
        }

        // Method to return the image path
        public String getImagePath() {
            return imagePath;
        }
    }

    // Static block initializes white pieces with image paths
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

    // Static block initializes black pieces with image paths
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

    // Method to display all pieces with image paths this does have print index tho
    public static void displayPieces() {
        System.out.println("White Pieces:");
        for (Piece p : Wpieces) {
            System.out.println(p.name + " at index: " + p.getIndex() + " | Image Path: " + p.getImagePath());
        }

        System.out.println("\nBlack Pieces:");
        for (Piece p : Bpieces) {
            System.out.println(p.name + " at index: " + p.getIndex() + " | Image Path: " + p.getImagePath());
        }
    }
}
  
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
