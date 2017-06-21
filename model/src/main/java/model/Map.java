package model;

import java.io.IOException;
import java.util.Observable;

import model.Element.IElement;

public class Map {
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	private IElement[][] onTheMap;

	 /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
	Map(String fileName) throws IOException {
        super();
        this.loadFile(fileName);
	}

	/**
	 * 
	 * @param fileName
	 */
	private void loadFile(String fileName) {
		// TODO - implement Map.loadFile
		throw new UnsupportedOperationException();
	}

	public int getWidth() {
		return this.width;
	}

	/**
	 * 
	 * @param width
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return this.height;
	}

	/**
	 * 
	 * @param height
	 */
	private void setHeight(int height) {
		this.height = height;
	}

	/**
	 * 
	 * @param x
	 * @param y
	 */
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}

	/**
	 * 
	 * @param element
	 */
	private void setOnTheMapXY(IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	public void setMobilehasChanged() {
		   this.setChanged();
	       this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}

}