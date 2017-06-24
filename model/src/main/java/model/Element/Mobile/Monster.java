package model.Element.Mobile;

import com.sun.javafx.geom.Rectangle;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;

public abstract class Monster extends Mobile {
	
	
	private static final IStrategy randomStrategy = new RandomMonsterStrategy();
	
	/** The static constant followWallClockWiseStrategy */
	private static final IStrategy followWallClockWiseStrategy = new FollowWallClockWiseStrategy();
	
	/** The static constant followWallAntiClockWiseStrategy */
	private static final IStrategy followWallAntiClockWiseStrategy = new FollowWallAntiClockWiseStrategy();
	
	/** The static constant noStrategy */
	private static final IStrategy noStrategy = new NoStrategy();
	
	/** The strategy in use by this monster */
	private IStrategy myStrategy = null;
	
	/** The last wall touched by this monster */
	private UserOrder lastWallTouched = UserOrder.NOP;

	public Monster(int x, int y, model.Element.Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, Permeability.BLOCKING);	
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param Map
	 */


	public void Movepatern(){
		super();
	}

	protected void die() {
		super.die();
        this.setSprite(spriteExplode);
	}

	public void doNothing() {
		super.doNothing();
        this.setSprite(sprite);
	}

}