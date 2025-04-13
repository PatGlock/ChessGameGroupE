import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ChessBoardDisplay {

    private JFrame frame;
    private JPanel[][] squares;
    private final int BOARD_SIZE = 8;

    public ChessBoardDisplay() {
        frame = new JFrame("Chess Board");
        frame.setSize(400, 400);
        frame.setLayout(new GridLayout(BOARD_SIZE, BOARD_SIZE));
        squares = new JPanel[BOARD_SIZE][BOARD_SIZE];


        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                squares[row][col] = new JPanel();
                if ((row + col) % 2 == 0) {
                    squares[row][col].setBackground(Color.WHITE);
                } else {
                    squares[row][col].setBackground(Color.LIGHT_GRAY);
                }
                frame.add(squares[row][col]);
            }
            public void displayPieces(List<Piece>board) {
                for (Piece piece : board) {
                    String pieceCall = "chess ";
                    String name = piece.getPiece();

                    name = switch (name) {
                        case "knight" -> "n";
                        case "king" -> "k";
                        case "rook" -> "r";
                        case "queen" -> "q";
                        case "bishop" -> "b";
                        case "pawn" -> "p";
                        case "blank" -> "bl";
                        default -> "zabagool";
                    }

                    pieceCall = pieceCall + name;
                    int color = piece.getColor();
                    char colorChar = ' ';

                    switch (color) {
                        case 1 -> colorChar = 'l';
                        case 2 -> colorChar = 'd';
                    }

                    pieceCall += colorChar;
                    pieceCall += "t60.png";

                    System.out.println(pieceCall);
                }
            }


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
        private void addPiece(int row, int col, String imagePath){
            ImageIcon icon = new ImageIcon(imagePath);
            JLabel label = new JLabel(icon);
            squares[row][col].add(label);

        }

        public static void main (String[]args){
            new ChessBoardDisplay();
        }
    }
}
