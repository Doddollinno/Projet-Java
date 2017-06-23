package model;

import java.io.IOException;

import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.IElement;
import model.IMap;
import model.Element.Permeability;
import java.util.Observable;
import contract.model.IMobile;

public class Map {
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The elements */
	private IElement[][] onTheMap;
	
	private ArrayList<IMobile> pawns;

	 /**
     * Instantiates a new road with the content of the file fileName.
     *
     * @param fileName
     *            the file name where the map of the road is
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */

	

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

	public void setMobile
	hasChanged() {
		   this.setChanged();
	       this.notifyObservers();
	}

	public Observable getObservable() {
		return this;
	}
	
	public ArrayList<IMobile> getPawns() 
	{
		return this.pawns;
		
	}
	  public Permeability getSquareIsOccupiedXY(final int x, final int y) {
		    Point point = new Point(x, y);
		    for(IMobile pawn : this.getPawns()) {
		      if (pawn.getPosition().equals(point))
		        return pawn.getPermeability();
		    }
}