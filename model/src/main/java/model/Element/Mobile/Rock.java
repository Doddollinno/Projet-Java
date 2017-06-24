package model.Element.Mobile;

import java.io.IOException;

import controller.IStrategy;
import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Strategy.BoulderStrategy;
import model.Element.Strategy.NoStrategy;


public class Rock extends Mobile{

	private static final Sprite SPRITE = new Sprite('R', "74359_28.png");
	private static IStrategy strategy = new BoulderStrategy();
	
	public Rock(int x, int y, Sprite sprite, IMap Map) throws IOException {
		super(x, y, sprite, Map, Permeability.BLOCKING);	
		}

	public Rock(int currentXToWrite, int currentYToWrite, IMap tempMap) throws IOException {
		super(currentXToWrite, currentYToWrite, SPRITE, tempMap, Permeability.BLOCKING);	
		SPRITE.loadImage();
	}

	@Override
	public Boolean IsDead() {
		return null;
	}

	@Override
	public void followMyStrategy() {
		Rock.strategy.followStrategy(this, this.getMap());
	}
	
	public void removeStrategy() {
		Rock.strategy = new NoStrategy();
	}
}
