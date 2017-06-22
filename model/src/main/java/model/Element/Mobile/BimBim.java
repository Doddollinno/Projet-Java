package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;

public class BimBim extends Monster {

	
	
	public BimBim(int x, int y, Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability);
		
	}
	
	public void Movepatern() {
		while (super.isAlive()){
			super.moveLeft();
			this.setSprite(BimBim);
			super.moveDown();
			this.setSprite(BimBim);
			super.moveRight();
			this.setSprite(BimBim);
			super.moveUp();
		}
		
	}

	protected void die() {
		super.die();
        this.setSprite(spriteExplode);
	}

	public void doNothing() {
		super.doNothing();
        this.setSprite(sprite);
	}

	@Override
	public Boolean IsDead() {
		return null;
	}
}
