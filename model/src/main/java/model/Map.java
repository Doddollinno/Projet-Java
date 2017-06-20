package model;

import java.util.Observable;

import model.Element.IElement;

public class Map {

	private int width;
	private int height;

	/**
	 * 
	 * @param fileName
	 */
	Map(String fileName) {
		// TODO - implement Map.Map
		throw new UnsupportedOperationException();
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
	public IElement getOnTheMapWY(int x, int y) {
		// TODO - implement Map.getOnTheMapWY
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param element
	 */
	private void setOnTheMapXY(IElement element) {
		// TODO - implement Map.setOnTheMapXY
		throw new UnsupportedOperationException();
	}

	public void setMobilehasChanged() {
		// TODO - implement Map.setMobilehasChanged
		throw new UnsupportedOperationException();
	}

	public Observable getObservable() {
		// TODO - implement Map.getObservable
		throw new UnsupportedOperationException();
	}

}