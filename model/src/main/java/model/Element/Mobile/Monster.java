package model.Element.Mobile;

import java.io.IOException;

import com.sun.javafx.geom.Rectangle;

import controller.IStrategy;
import controller.UserOrder;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Strategy.MonsterStrategy;

public class Monster extends Mobile {
	
	
	private static final IStrategy randomStrategy = new MonsterStrategy();
	
	private static Sprite SPRITE = new Sprite('M',"74359_10.png");
	private static Sprite spriteDeath = new Sprite('M',"74359_46.png");
	
	/** The strategy in use by this monster */
	private IStrategy myStrategy = randomStrategy;
	
	/** The last wall touched by this monster */
	private UserOrder lastWallTouched = UserOrder.NOP;

	public Monster(int x, int y, model.Element.Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, Permeability.BLOCKING);	
	}
	
	public Monster(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
		super(currentXToWrite, currentYToWrite, SPRITE, tempMap, Permeability.BLOCKING);	
		SPRITE.loadImage();
		this.myStrategy = Monster.randomStrategy;
	}

	/**
	 * Instantiates a new monster.
	 *
	 * @param x
	 *            the x
	 * @param y
	 *            the y
	 * @param map
	 *            the map
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */

	@Override
	public final void moveLeft() {
		super.moveLeft();
	}

	@Override
	public final void moveRight() {
		super.moveRight();
	}

	@Override
	public final void moveUp() {
		super.moveUp();
	}

	@Override
	public final void moveDown() {
		super.moveDown();
	}

	protected void die() {
		super.die();
		this.setSprite(spriteDeath);
	}

	public void doNothing() {
		super.doNothing();
        this.setSprite(SPRITE);
	}

	@Override
	public void followMyStrategy() {
		this.myStrategy.followStrategy(this, this.getMap());
	}
	
	@Override
	public UserOrder getLastWallTouched() {
		return this.lastWallTouched;
	}

	@Override
	public void setLastWallTouched(final UserOrder userOrder) {
		this.lastWallTouched = userOrder;
	}

	@Override
	public Boolean IsDead() {
		// TODO Auto-generated method stub
		return null;
	}

}