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

public class Map extends Observable implements IMap{
	
	/** The width. */
	private int width;
	
	/** The height. */
	private int height;
	
	/** The elements */
	private IElement[][] onTheMap;
	
	/** The Pawn list */
	private ArrayList<IMobile> pawns;
	
	/** The myCharacter */
	  private IMobile myCharacter = null;
	  
	  /** The diamond count */
	  private int diamondCount = 0;


	  
	  public Map(final int newWidth, final int newHeight, final IElement[][] newMap) throws SQLException {
		    super();
		    this.onTheMap = newMap;
		    this.width = newWidth;
		    this.height = newHeight;
		    this.pawns = new ArrayList<IMobile>();
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
	public void setOnTheMapXY(IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	public void setMobilehasChanged() {
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
	
	  public IMobile getMyCharacter() {
	    return this.myCharacter;
	  }
	
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

	 public void decreaseDiamondCount() {
	    this.diamondCount--;
	  }

	  public void addDiamondCount() {
	    this.diamondCount++;
	  }

	  public int getDiamondCount() {
	    return this.diamondCount;
	  }



	@Override
	public void setOnTheMapXY(int x, int y, Element element) {
		this.onTheMap[x][y] = element;
	}



	@Override
	  public final void setMobileHasChanged() {
	    this.setChanged();
	    this.notifyObservers();
	  }



	@Override
	  public void addPawn(IMobile pawn) {
	    this.pawns.add(pawn);
	  }



	@Override
	public void setMyCharacter(IMobile character) {
		// TODO Auto-generated method stub
		this.myCharacter = character;
	}
}