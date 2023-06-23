import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.nio.file.Files;
import java.nio.file.Path;

class Program {
    public static void main(String[] args) {
        String imagePath = "/home/ael-hiou/Downloads/it.bmp";

        try {
            byte[] data = Files.readAllBytes(Path.of(imagePath));
            processBinaryImage(data);
        }
        catch (IOException e) {
            System.out.println("An error occurred while reading the BMP image: " + e.getMessage());
        }
    }

    public static void processBinaryImage(byte[] imageData) {
        // Access individual pixels and perform desired operations
        int width = extractInteger(imageData, 18, 4);
        int height = extractInteger(imageData, 22, 4);

        int pixelOffset = extractInteger(imageData, 10, 4);
        int bitsPerPixel = extractInteger(imageData, 28, 2);

        int rowSize = calculateRowSize(width, bitsPerPixel);
        int imageSize = rowSize * height;

        // Access and process the binary image data
        for (int i = pixelOffset; i < pixelOffset + imageSize; i++) {
            int byteValue = imageData[i] & 0xFF; // Convert signed byte to unsigned
//            if (i == imageSize)
            for (int j = 7; j >= 0; j--) {
                int bit = (byteValue >> j) & 1;

                if (bit == 0) {
                    System.out.print("0");
                    // Pixel is black
                    // Perform desired operations for black pixels
                } else {
                    System.out.print(".");
                    // Pixel is white
                    // Perform desired operations for white pixels
                }
            }
        }
    }

    public static int extractInteger(byte[] data, int offset, int length) {
        int result = 0;
        for (int i = offset + length - 1; i >= offset; i--) {
            result = (result << 8) | (data[i] & 0xFF);
        }
        return result;
    }

    public static int calculateRowSize(int width, int bitsPerPixel) {
        int bytesPerRow = (width * bitsPerPixel + 31) / 32 * 4;
        return bytesPerRow;
    }
}