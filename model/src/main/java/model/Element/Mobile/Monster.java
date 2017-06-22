package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;

public abstract class Monster extends Mobile {

	public Monster(int x, int y, model.Element.Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability.BLOCKING);
		
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param Map
	 */


	public void Movepatern() {
		
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