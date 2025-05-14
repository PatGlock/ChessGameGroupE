import javax.swing.*;
import java.awt.*;

public class ChessBoardDisplay {
    private JFrame frame;
    private JPanel[][] squares;
    private final int BOARD_SIZE = 8;

    public ChessBoardDisplay() {
        frame = new JFrame("Chess Board");
        frame.setSize(600, 600); // Increased size for better spacing
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

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    // Method to add a piece to the board at a given row/column
    public void addPiece(int row, int col, String imagePath) {
        ImageIcon icon = new ImageIcon(imagePath);
        JLabel label = new JLabel(icon);

        squares[row][col].removeAll(); // Clear previous components if needed
        squares[row][col].add(label);

        squares[row][col].revalidate(); // Refresh panel
        squares[row][col].repaint(); // Redraw panel
    }
}
