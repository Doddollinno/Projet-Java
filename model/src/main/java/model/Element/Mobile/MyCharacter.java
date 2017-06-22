package model.Element.Mobile;

import java.io.IOException;

import model.IMap;
import model.Element.Permeability;

public abstract class MyCharacter extends Mobile {

	/**
	 * 
	 * @param x
	 * @param y
	 * @param Map
	 */
	
	private int Diamonds;
	public MyCharacter(final int x, final int y, final IMap Map)   {
		super(x, Map, y, sprite, Permeability.BLOCKING);
		spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteTurnDown.loadImage();
        spriteTurnUp.loadImage();
        spriteDeath.loadImage();
        
        this.Diamonds = 0;
	}
	
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}
		
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}
		
	public void moveLeft() {
		super.moveLeft();
        this.setSprite(spriteTurnLeft);
	}

	public void moveRight() {
		super.moveRight();
        this.setSprite(spriteTurnRight);
	}

	protected void die() {
		super.die();
        this.setSprite(spriteDeath);
	}

	public void doNothing() {
		super.doNothing();
        this.setSprite(sprite);
	}


}