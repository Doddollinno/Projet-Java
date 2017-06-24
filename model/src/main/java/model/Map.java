package model;

import java.io.IOException;


import java.awt.Point;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Observable;

import model.IElement;
import model.Element.Element;
import model.Element.Permeability;
import model.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class Map.
 */
public class Map extends Observable implements IMap{
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/**  The elements. */
	private IElement[][] onTheMap;
	
	/**  The Pawn list. */
	private ArrayList<IMobile> pawns;
	
	/**  The myCharacter. */
	  private IMobile myCharacter = null;
	  
	  /**  The diamond count. */
	  private int diamondCount = 0;


	  
	  /**
  	 * Instantiates a new map.
  	 *
  	 * @param newWidth the new width
  	 * @param newHeight the new height
  	 * @param newMap the new map
  	 * @throws SQLException the SQL exception
  	 */
  	public Map(final int newWidth, final int newHeight, final IElement[][] newMap) throws SQLException {
		    super();
		    this.onTheMap = newMap;
		    this.width = newWidth;
		    this.height = newHeight;
		    this.pawns = new ArrayList<IMobile>();
		  }



	/** (non-Javadoc)
	 * @see model.IMap#getWidth()
	 */
	public int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	private void setWidth(int width) {
		this.width = width;
	}

	/** (non-Javadoc)
	 * @see model.IMap#getHeight()
	 */
	public int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	private void setHeight(int height) {
		this.height = height;
	}

	/**
	 * Gets the on the map XY.
	 *
	 * @param x the x
	 * @param y the y
	 * @return the on the map XY
	 */
	public IElement getOnTheMapXY(int x, int y) {
		return this.onTheMap[x][y];
	}

	/**
	 * Sets the on the map XY.
	 *
	 * @param element the element
	 * @param x the x
	 * @param y the y
	 */
	public void setOnTheMapXY(IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	/**
	 * Sets the mobilehas changed.
	 */
	public void setMobilehasChanged() {
		   this.setChanged();
	       this.notifyObservers();
	}

	/** (non-Javadoc)
	 * @see model.IMap#getObservable()
	 */
	public Observable getObservable() {
		return this;
	}
	
	/**(non-Javadoc)
	 * @see model.IMap#getPawns()
	 */
	public ArrayList<IMobile> getPawns() 
	{
		return this.pawns;
		
	}
	
	  /** (non-Javadoc)
  	 * @see model.IMap#getMyCharacter()
  	 */
  	public IMobile getMyCharacter() {
	    return this.myCharacter;
	  }
	
	 /** (non-Javadoc)
 	 * @see model.IMap#getSquareIsOccupiedXY(int, int)
 	 */
 	public Permeability getSquareIsOccupiedXY(final int x, final int y) {
		    Point point = new Point(x, y);
		    for(IMobile pawn : this.getPawns()) {
		      if (pawn.getPosition().equals(point))
		        return pawn.getPermeability();
		    }
		    
		    if(this.getMyCharacter().getPosition().equals(point))
		    	return this.getMyCharacter().getPermeability();
		    
		    return this.getOnTheMapXY(x, y).getPermeability();
		  }

	 /** (non-Javadoc)
 	 * @see model.IMap#decreaseDiamondCount()
 	 */
 	public void decreaseDiamondCount() {
	    this.diamondCount--;
	  }

	  /** (non-Javadoc)
  	 * @see model.IMap#addDiamondCount()
  	 */
  	public void addDiamondCount() {
	    this.diamondCount++;
	  }

	  /** (non-Javadoc)
  	 * @see model.IMap#getDiamondCount()
  	 */
  	public int getDiamondCount() {
	    return this.diamondCount;
	  }



	/** (non-Javadoc)
	 * @see model.IMap#setOnTheMapXY(int, int, model.Element.Element)
	 */
	@Override
	public void setOnTheMapXY(int x, int y, Element element) {
		this.onTheMap[x][y] = element;
	}



	/** (non-Javadoc)
	 * @see model.IMap#setMobileHasChanged()
	 */
	@Override
	  public final void setMobileHasChanged() {
	    this.setChanged();
	    this.notifyObservers();
	  }



	/** (non-Javadoc)
	 * @see model.IMap#addPawn(model.IMobile)
	 */
	@Override
	  public void addPawn(IMobile pawn) {
	    this.pawns.add(pawn);
	  }



	/** (non-Javadoc)
	 * @see model.IMap#setMyCharacter(model.IMobile)
	 */
	@Override
	public void setMyCharacter(IMobile character) {
		// TODO Auto-generated method stub
		this.myCharacter = character;
	}
}