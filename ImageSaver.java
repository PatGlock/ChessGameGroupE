import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL; // Import for resource loading

public class ImageSaver {
    private final BufferedImage[] pieceImages; // Corrected array declaration

    // Constructor to initialize the images
    public ImageSaver() {
        pieceImages = new BufferedImage[12]; // Fixed array size
        initPieceImages();
    }

    // Load images from resources or local folder
    private void initPieceImages() {
        String[] imageFiles = {"BishopB", "BishopW", "KingW", "KingB", "KnightB", "KnightW",
                "PawnB", "PawnW", "QueenB", "QueenW", "RookB", "RookW"};

        for (int i = 0; i < imageFiles.length; i++) {
            try {
                // Step 1: Try loading from project resources
                URL resourcePath = getClass().getResource("/images/" + imageFiles[i] + ".png");
                System.out.println("Checking resource path for " + imageFiles[i] + ": " + resourcePath);

                if (resourcePath != null) {
                    pieceImages[i] = ImageIO.read(resourcePath);
                    System.out.println(imageFiles[i] + " loaded successfully from resources!");
                } else {
                    // Step 2: Try loading from local folder
                    File imageFile = new File("images/" + imageFiles[i] + ".png");
                    System.out.println("Checking local path for " + imageFiles[i] + ": " + imageFile.getAbsolutePath());

                    if (imageFile.exists()) {
                        pieceImages[i] = ImageIO.read(imageFile);
                        System.out.println(imageFiles[i] + " loaded successfully from local folder!");
                    } else {
                        System.out.println("Error: " + imageFiles[i] + " not found in local folder!");
                    }
                }
            } catch (IOException e) {
                System.out.println("Failed to load " + imageFiles[i]);
                e.printStackTrace();
            }
        }
    }

    // Method to get an image by index
    public BufferedImage getImage(int index) {
        return pieceImages[index];
    }
}
