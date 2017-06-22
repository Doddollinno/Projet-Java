package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;

public class PuffPuff extends Monster {

	public PuffPuff(int x, int y, Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability);
		// TODO Auto-generated constructor stub
	}
	
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
