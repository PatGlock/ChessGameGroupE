import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL; // Added missing import

public class ImageSaver {
    private final BufferedImage[] pieceImages;

    // Constructor to initialize the images
    public ImageSaver() {
        pieceImages = new BufferedImage[6]; // Fixed array size to hold all images
        initPieceImages();
    }

    // Load images directly from resources inside the class
    private void initPieceImages() {
        String[] imageFiles = {"download.png"};

        for (int i = 0; i < imageFiles.length; i++) {
            try {
                // Step 1: Try loading from project resources
                URL resourcePath = getClass().getResource("/images/" + imageFiles[i]);
                System.out.println("Checking resource path for " + imageFiles[i] + ": " + resourcePath);

                if (resourcePath != null) {
                    pieceImages[i] = ImageIO.read(resourcePath);
                    System.out.println(imageFiles[i] + " loaded successfully from resources!");
                } else {
                    // Step 2: Try loading from local folder
                    File imageFile = new File("images/" + imageFiles[i]);
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

    // Method to get an image
    public BufferedImage getImage(int index) {
        return pieceImages[index];
    }
}