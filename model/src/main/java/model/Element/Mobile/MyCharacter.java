package model.Element.Mobile;

import java.awt.Point;
import java.io.IOException;

import controller.UserOrder;
import model.Element.Sprite;
import model.IMap;
import model.IMobile;
import model.Element.Permeability;

public class MyCharacter extends Mobile {
	
	
	private int diamonds;

	/** The Constant SPRITE. */
    private static final Sprite sprite          = new Sprite('H', "74336_04.png");

    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnLeft  = new Sprite('H', "74336_08.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnRight = new Sprite('H', "74336_19.png");
    
    /** The Constant spriteTurnLeft. */
    private static final Sprite spriteTurnUp  = new Sprite('H', "74336_11.png");

    /** The Constant spriteTurnRight. */
    private static final Sprite spriteTurnDown = new Sprite('H', "74336_12.png");

    /** The Constant spriteExplode. */
    private static final Sprite spriteDeath   = new Sprite('H', "74336_05.png");
	
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param Map
	 */
	
	public MyCharacter(final int x, final int y, final IMap Map) throws IOException   {
		super(x, y, sprite, Map, Permeability.BLOCKING);
		sprite.loadImage();
		spriteTurnLeft.loadImage();
        spriteTurnRight.loadImage();
        spriteTurnDown.loadImage();
        spriteTurnUp.loadImage();
        spriteDeath.loadImage();
        
        this.diamonds = 0;
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

	@Override
	public Boolean IsDead() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void followMyStrategy() {
		// TODO Auto-generated method stub
		
	}
}
