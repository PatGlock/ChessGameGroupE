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
        addPiece(0, 0, "RookB.png");
        addPiece(7, 7, "RookW.png");
        addPiece(0, 1, "rook_black.png");
        addPiece(7, 6, "rook_white.png");
        addPiece(0, 2, "rook_black.png");
        addPiece(7, 5, "rook_white.png");
        addPiece(0, 3, "rook_black.png");
        addPiece(7, 4, "rook_white.png");
        addPiece(0, 0, "rook_black.png");
        addPiece(7, 7, "rook_white.png");
        addPiece(0, 0, "rook_black.png");
        addPiece(7, 7, "rook_white.png");
        addPiece(0, 0, "rook_black.png");
        addPiece(7, 7, "rook_white.png");
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
            new ChessBoardDisplay(); {
            for (int i=0; i<8; i++); {

                    for (int j=0; j<8; j++);{
                        if (board[i][j]==null) {
                            System.out.print(" . ");
                        } else {
                            System.out.print(" "+ board[i][j] + " ");
                        }
                    }
                    System.out.println();
                }
            }
            private static void ChessBoardDisplay (String[] args) {
                ChessBoard chessBoard = new ChessBoard();
                chessBoard.displayBoard();
            }
        }public final void initPieceImages() {
            // Black piece images
            pieceImage_b[0] = new ImageIcon(new ImageIcon("KingB.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[1] = new ImageIcon(new ImageIcon(".png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[2] = new ImageIcon(new ImageIcon("./img/bishop_b.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[3] = new ImageIcon(new ImageIcon("./img/knight_b.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[4] = new ImageIcon(new ImageIcon("./img/rook_b.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[5] = new ImageIcon(new ImageIcon("./img/pawn_b.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_b[6] = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));

            // White piece images
            pieceImage_w[0] = new ImageIcon(new ImageIcon("./img/king_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[1] = new ImageIcon(new ImageIcon("./img/queen_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[2] = new ImageIcon(new ImageIcon("./img/bishop_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[3] = new ImageIcon(new ImageIcon("./img/knight_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[4] = new ImageIcon(new ImageIcon("./img/rook_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[5] = new ImageIcon(new ImageIcon("./img/pawn_w.png").getImage().getScaledInstance(64, 64, Image.SCALE_SMOOTH));
            pieceImage_w[6] = new ImageIcon(new BufferedImage(64, 64, BufferedImage.TYPE_INT_ARGB));
        }

        // Retrieves the image icon for a given chess piece.
        public ImageIcon getImageIcon(Piece piece) {
            if(piece.color.equals(PlayerColor.black)) {
                if(piece.type.equals(PieceType.king)) return pieceImage_b[0];
                else if(piece.type.equals(PieceType.queen)) return pieceImage_b[1];
                else if(piece.type.equals(PieceType.bishop)) return pieceImage_b[2];
                else if(piece.type.equals(PieceType.knight)) return pieceImage_b[3];
                else if(piece.type.equals(PieceType.rook)) return pieceImage_b[4];
                else if(piece.type.equals(PieceType.pawn)) return pieceImage_b[5];
                else return pieceImage_b[6];
            }
            else if(piece.color.equals(PlayerColor.white)) {
                if(piece.type.equals(PieceType.king)) return pieceImage_w[0];
                else if(piece.type.equals(PieceType.queen)) return pieceImage_w[1];
                else if(piece.type.equals(PieceType.bishop)) return pieceImage_w[2];
                else if(piece.type.equals(PieceType.knight)) return pieceImage_w[3];
                else if(piece.type.equals(PieceType.rook)) return pieceImage_w[4];
                else if(piece.type.equals(PieceType.pawn)) return pieceImage_w[5];
                else return pieceImage_w[6];
            }
            else return pieceImage_w[6];
        }

    }

