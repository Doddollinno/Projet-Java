package model.Element.Mobile;

import java.io.IOException;
import java.util.Observable;

import controller.IStrategy;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Motionless.MotionlessElement;
import model.Element.Strategy.DiamondStrategy;

/**
 * The Class Diamond.
 */
public class Diamond extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('D', "74359_17.png");
	
	/** The Constant strategy. */
	private static final IStrategy strategy = new DiamondStrategy();

	/**
	 * Instantiates a new diamond.
	 *
	 * @param sprite the sprite
	 * @param Map the map
	 * @param permeability the permeability
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Diamond(Sprite sprite, IMap Map, Permeability permeability) throws IOException {
		super(sprite, Map, permeability);
		sprite.loadImage();
	}
	
	/**
	 * Instantiates a new diamond.
	 *
	 * @param currentXToWrite the current X to write
	 * @param currentYToWrite the current Y to write
	 * @param tempMap the temp map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public Diamond(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
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
		Diamond.strategy.followStrategy(this, this.getMap());
	}

}