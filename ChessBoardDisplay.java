import javax.swing.*;
import java.awt.*;

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
        }

        // this part will be the teammates to replace with the logic of the game
        addPiece(0, 0, "rook_black.png");
        addPiece(7, 7, "rook_white.png");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    private void addPiece(int row, int col, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);
        squares[row][col].add(label);

    }
    public class ChessBoard {
        private String[][] board;
        private ChessGame game;
    public ChessBoard(){
        board = new String[8][8];
        game = new ChessGame();
        updateBoard();
    }
private void updateBoard(){
        for(Piece piece : game.getPieces()){
            board[piece.getRow()][piece.getCol()] = piece.getType().charAt(0)+ piece.getColor().charAt(0);
        }
}


    public void ChessBoardDisplay(String[] args) {
        new ChessBoardDisplay(){
            for(int i=0; i<8; i++){
                for (int j=0; j<8; j++){
                    if (board[i][j]==null) {
                        System.out.print(" . ");
                    } else {
                        System.out.print(" "+ board[i][j] + " ");
                    }
                    }
                System.out.println();
                }
            }
    public static void ChessBoardDisplay(String[] args) {
            ChessBoard chessBoard = new ChessBoard(); chessBoard.displayBoard();
        }
    }

}

}
