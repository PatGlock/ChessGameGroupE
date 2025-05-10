import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ImageSaver imageSaver = new ImageSaver();

        // Create a JFrame to display the image
        JFrame frame = new JFrame("Chess Piece Display");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        // Convert BufferedImage to an ImageIcon
        ImageIcon icon = new ImageIcon(imageSaver.getImage(0)); // Get the King image

        // Display the image in a JLabel
        JLabel label = new JLabel(icon);
        frame.add(label);

        frame.setVisible(true);
    }
}