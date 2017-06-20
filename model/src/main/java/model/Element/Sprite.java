package model.Element;

import java.awt.Image;

public class Sprite {

	private Image image;
	private String imageName;
	private int consoleImage;
	private boolean imageLoaded;

	/**
	 * 
	 * @param character
	 * @param imageName
	 */
	public Sprite(char character, String imageName) {
		// TODO - implement Sprite.Sprite
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param character
	 */
	public Sprite(char character) {
		// TODO - implement Sprite.Sprite
		throw new UnsupportedOperationException();
	}

	public Image getImage() {
		return this.image;
	}

	public void loadImage() {
		// TODO - implement Sprite.loadImage
		throw new UnsupportedOperationException();
	}

	public char getConsoleImage() {
		// TODO - implement Sprite.getConsoleImage
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param ConsoleImage
	 */
	private void setConsoleImage(char ConsoleImage) {
		// TODO - implement Sprite.setConsoleImage
		throw new UnsupportedOperationException();
	}

	public String getImageName() {
		return this.imageName;
	}

	/**
	 * 
	 * @param imageName
	 */
	private void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public boolean isImageLoaded() {
		return this.imageLoaded;
	}

	/**
	 * 
	 * @param isImageLoaded
	 */
	public void setImageLoaded(boolean isImageLoaded) {
		this.imageLoaded = isImageLoaded;
	}

}