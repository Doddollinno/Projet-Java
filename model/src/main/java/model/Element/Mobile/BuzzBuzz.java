package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;

public class BuzzBuzz extends Monster {

	public BuzzBuzz(int x, int y, Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability);
		// TODO Auto-generated constructor stub
	}
	
	public void Movepatern() {
		
		super.moveRight();
		this.setSprite(BuzzBuzz);
		super.moveDown();
		this.setSprite(BuzzBuzz);
		super.moveLeft();
		this.setSprite(BuzzBuzz);
		super.moveUp();
		
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
