package model.Element.Mobile;

import java.io.IOException;

import controller.IStrategy;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Strategy.BoulderStrategy;
import model.Element.Strategy.NoStrategy;


/**
 * The Class Rock.
 */
public class Rock extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('R', "74359_28.png");
	
	/** The strategy. */
	private static IStrategy strategy = new BoulderStrategy();
	
	/**
	 * Instantiates a new rock.
	 *
	 * @param x the x
	 * @param y the y
	 * @param sprite the sprite
	 * @param Map the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Rock(int x, int y, Sprite sprite, IMap Map) throws IOException {
		super(x, y, sprite, Map, Permeability.BLOCKING);	
		}

	/**
	 * Instantiates a new rock.
	 *
	 * @param currentXToWrite the current X to write
	 * @param currentYToWrite the current Y to write
	 * @param tempMap the temp map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Rock(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
		super(currentXToWrite, currentYToWrite, SPRITE, tempMap, Permeability.BLOCKING);	
		SPRITE.loadImage();
	}

	/** (non-Javadoc)
	 * @see model.IMobile#IsDead()
	 */
	@Override
	public Boolean IsDead() {
		return null;
	}

	/** (non-Javadoc)
	 * @see model.IMobile#followMyStrategy()
	 */
	@Override
	public void followMyStrategy() {
		Rock.strategy.followStrategy(this, this.getMap());
	}
	
	/**
	 * Removes the strategy.
	 */
	public void removeStrategy() {
		Rock.strategy = new NoStrategy();
	}
}
