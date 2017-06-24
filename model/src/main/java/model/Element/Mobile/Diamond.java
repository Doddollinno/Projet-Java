package model.Element.Mobile;

import java.io.IOException;
import java.util.Observable;

import controller.IStrategy;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Motionless.MotionlessElement;
import model.Element.Strategy.DiamondStrategy;

public class Diamond extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('D', "74359_17.png");
	private static final IStrategy strategy = new DiamondStrategy();

	public Diamond(Sprite sprite, IMap Map, Permeability permeability) throws IOException {
		super(sprite, Map, permeability);
		sprite.loadImage();
	}
	
	public Diamond(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
		super(currentXToWrite, currentYToWrite, SPRITE, tempMap, Permeability.BLOCKING);	
		SPRITE.loadImage();
	}


	@Override
	public Boolean IsDead() {
		return null;

	}


	@Override
	public void followMyStrategy() {
		Diamond.strategy.followStrategy(this, this.getMap());
	}

}