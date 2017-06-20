package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;

public abstract class Monster extends Mobile {

	public Monster(int x, int y, model.Element.Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability);
		// TODO Auto-generated constructor stub
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param Map
	 */
	public void Monster1(int x, int y, IMap Map) {
		// TODO - implement Monster.Monster1
		throw new UnsupportedOperationException();
	}

	public void Movepatern() {
		// TODO - implement Monster.Movepatern
		throw new UnsupportedOperationException();
	}

	protected void die() {
		// TODO - implement Monster.die
		throw new UnsupportedOperationException();
	}

	public void doNothing() {
		// TODO - implement Monster.doNothing
		throw new UnsupportedOperationException();
	}

}