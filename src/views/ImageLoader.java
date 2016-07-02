package views;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * Implemented by Peter Camejo
 */
public class ImageLoader {

    public BufferedImage loadImage(String path){
        System.out.println(path);
        try {
            return ImageIO.read(getClass().getResourceAsStream(path));
        } catch(IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
        System.out.println("Error: Image load failed");
        return null;
    }
}