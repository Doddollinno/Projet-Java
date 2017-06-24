package model.Element;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Sprite {


	/** The image. */
	private Image image;
	
	/** The image name */
	private String imageName;

	/** The console image. */
	private char consoleImage;

	/** The is image loaded. */
	private boolean imageLoaded;

	/** The buffer for the character images */
	public static BufferedImage characterTileSet = null;

	/** The buffer for the map images */
	public static BufferedImage mapTileSet = null;



    public Sprite(final char character, final String imageName) {
        this.setConsoleImage(character);
        this.setImageName(imageName);
    }


    public Sprite(final char character) {
        this(character, "noimage.jpg");
    }


    public final Image getImage() {
        return this.image;
    }
    

    private void setImage(final Image image) {
        this.image = image;
    }

    public final void loadImage() throws IOException {
        this.setImage(ImageIO.read(new File("Sprite/" + this.getImageName())));
    }


    public final char getConsoleImage() {
        return this.consoleImage;
    }


    private void setConsoleImage(final char consoleImage) {
        this.consoleImage = consoleImage;
    }


    public final String getImageName() {
        return this.imageName;
    }


    private void setImageName(final String imageName) {
        this.imageName = imageName;
    }


    public final boolean isImageLoaded() {
        return this.imageLoaded;
    }


    public final void setImageLoaded(final boolean isImageLoaded) {
        this.imageLoaded = isImageLoaded;
    }


    /**
	 * Loads the buffers for the characters and the map
	 */


}