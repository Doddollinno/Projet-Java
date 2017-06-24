package model.Element.Mobile;

import java.io.IOException;

import com.sun.javafx.geom.Rectangle;

import controller.IStrategy;
import controller.UserOrder;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Strategy.MonsterStrategy;

/**
 * The Class Monster.
 */
public class Monster extends Mobile {
	
	
	/** The Constant randomStrategy. */
	private static final IStrategy randomStrategy = new MonsterStrategy();
	
	/** The sprite. */
	private static Sprite SPRITE = new Sprite('M',"74359_10.png");
	
	/** The sprite death. */
	private static Sprite spriteDeath = new Sprite('M',"74359_46.png");
	
	/**  The strategy in use by this monster. */
	private IStrategy myStrategy = randomStrategy;
	
	/**  The last wall touched by this monster. */
	private UserOrder lastWallTouched = UserOrder.NOP;

	/**
	 * Instantiates a new monster.
	 *
	 * @param x the x
	 * @param y the y
	 * @param sprite the sprite
	 * @param Map the map
	 * @param permeability the permeability
	 */
	public Monster(int x, int y, model.Element.Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, Permeability.BLOCKING);	
	}
	
	/**
	 * Instantiates a new monster.
	 *
	 * @param currentXToWrite the current X to write
	 * @param currentYToWrite the current Y to write
	 * @param tempMap the temp map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Monster(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
		super(currentXToWrite, currentYToWrite, SPRITE, tempMap, Permeability.BLOCKING);	
		SPRITE.loadImage();
		this.myStrategy = Monster.randomStrategy;
	}

	/**
	 * Instantiates a new monster.
	 */

	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveRight()
	 */
	@Override
	public final void moveRight() {
		super.moveRight();
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveUp()
	 */
	@Override
	public final void moveUp() {
		super.moveUp();
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#moveDown()
	 */
	@Override
	public final void moveDown() {
		super.moveDown();
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#die()
	 */
	protected void die() {
		super.die();
		this.setSprite(spriteDeath);
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#doNothing()
	 */
	public void doNothing() {
		super.doNothing();
        this.setSprite(SPRITE);
	}

	/**(non-Javadoc)
	 * @see model.IMobile#followMyStrategy()
	 */
	@Override
	public void followMyStrategy() {
		this.myStrategy.followStrategy(this, this.getMap());
	}
	
	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#getLastWallTouched()
	 */
	@Override
	public UserOrder getLastWallTouched() {
		return this.lastWallTouched;
	}

	/**(non-Javadoc)
	 * @see model.Element.Mobile.Mobile#setLastWallTouched(controller.UserOrder)
	 */
	@Override
	public void setLastWallTouched(final UserOrder userOrder) {
		this.lastWallTouched = userOrder;
	}

	/**(non-Javadoc)
	 * @see model.IMobile#IsDead()
	 */
	@Override
	public Boolean IsDead() {
		// TODO Auto-generated method stub
		return null;
	}

}