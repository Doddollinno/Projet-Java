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
	public Monster1( int x,  int y, model.Element.Sprite sprite,  IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability.BLOCKING);
		spriteMonster1.loadImage();
		
	}

	public void Movepatern() {
		super.moveRight();
		this.setSprite(SpriteMonster1);
		super.moveDown();
		this.setSprite(SpriteMonster1);
		super.moveLeft();
		this.setSprite(SpriteMonster1);
		super.moveUp();
		this.setSprite(SpriteMonster1);
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