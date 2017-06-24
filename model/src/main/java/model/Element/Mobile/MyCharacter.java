package model.Element.Mobile;

import java.io.IOException;

import model.Element.Sprite;
import model.IMap;
import model.Element.Permeability;

public abstract class MyCharacter extends Mobile {

	/** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "MyCharacter.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "MyCharacterLeft.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "MyCharacterRight.png");
    
    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnUp  = new Sprite('H', "MyCharacterUp.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnDown = new Sprite('H', "MyCharacterDown.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteDeath   = new Sprite('H', "MyCharacterExplode.png");
	
	
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

	public void die() {
		super.die();
        this.setSprite(spriteDeath);
	}

	public void doNothing() {
		super.doNothing();
        this.setSprite(sprite);
	}


}