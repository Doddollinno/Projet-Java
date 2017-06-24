package model.Element.Mobile;

import java.awt.Point;
import java.io.IOException;

import controller.UserOrder;
import model.Element.Sprite;
import model.IMap;
import model.IMobile;
import model.Element.Permeability;

/**
 * The Class MyCharacter.
 */
public class MyCharacter extends Mobile {
	
	
	/** The diamonds. */
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
	 * Instantiates a new my character.
	 *
	 * @param x the x
	 * @param y the y
	 * @param Map the map
	 * @throws IOException Signals that an I/O exception has occurred.
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
	
	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveDown()
	 */
	public void moveDown() {
		super.moveDown();
		this.setSprite(spriteTurnDown);
	}
		
	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveUp()
	 */
	public void moveUp() {
		super.moveUp();
		this.setSprite(spriteTurnUp);
	}
		
	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveLeft()
	 */
	public void moveLeft() {
		super.moveLeft();
        this.setSprite(spriteTurnLeft);
	}

	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveRight()
	 */
	public void moveRight() {
		super.moveRight();
        this.setSprite(spriteTurnRight);
	}

	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#die()
	 */
	public void die() {
		super.die();
        this.setSprite(spriteDeath);
	}

	/** (non-Javadoc)
	 * @see model.Element.Mobile.Mobile#doNothing()
	 */
	public void doNothing() {
		super.doNothing();
        this.setSprite(sprite);
	}

	/** (non-Javadoc)
	 * @see model.IMobile#IsDead()
	 */
	@Override
	public Boolean IsDead() {
		// TODO Auto-generated method stub
		return null;
	}

	/** (non-Javadoc)
	 * @see model.IMobile#followMyStrategy()
	 */
	@Override
	public void followMyStrategy() {
		// TODO Auto-generated method stub
		
	}
}
