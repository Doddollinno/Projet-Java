package model.Element.Mobile;

import java.awt.Point;

import model.IMap;
import model.Element.Element;
import model.Element.IElement;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Mobile.IMobile.*;

public abstract class Mobile extends Element implements IMap {

	private Point position;
	private Boolean Alive = true;

	/**
	 * 
	 * @param sprite
	 * @param Map
	 * @param permeability
	 */
	public Mobile(Sprite sprite, IMap Map, Permeability permeability) {
		super (sprite, permeability);
		
		// TODO - implement Mobile.Mobile
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param Map
	 * @param permeability
	 */
	public Mobile(int x, int y, Sprite sprite, IMap Map, Permeability permeability) {
		super (sprite, permeability);
		// TODO - implement Mobile.Mobile
		throw new UnsupportedOperationException();
	}

	public void moveUp() {
		// TODO - implement Mobile.moveUp
		throw new UnsupportedOperationException();
	}

	public void moveLeft() {
		// TODO - implement Mobile.moveLeft
		throw new UnsupportedOperationException();
	}

	public void moveRight() {
		// TODO - implement Mobile.moveRight
		throw new UnsupportedOperationException();
	}

	public void moveDown() {
		// TODO - implement Mobile.moveDown
		throw new UnsupportedOperationException();
	}

	public void doNothing() {
		// TODO - implement Mobile.doNothing
		throw new UnsupportedOperationException();
	}

	private void setHasMoved() {
		// TODO - implement Mobile.setHasMoved
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 */
	public void getX(int x) {
		// TODO - implement Mobile.getX
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param x
	 */
	public void setX(int x) {
		// TODO - implement Mobile.setX
		throw new UnsupportedOperationException();
	}

	public int getY() {
		// TODO - implement Mobile.getY
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param y
	 */
	public void setY(int y) {
		// TODO - implement Mobile.setY
		throw new UnsupportedOperationException();
	}

	public IMap getMap() {
		// TODO - implement Mobile.getMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param map
	 */
	private void setMap(IMap map) {
		// TODO - implement Mobile.setMap
		throw new UnsupportedOperationException();
	}

	public Boolean isAlive() {
		// TODO - implement Mobile.isAlive
		throw new UnsupportedOperationException();
	}

	protected void die() {
		// TODO - implement Mobile.die
		throw new UnsupportedOperationException();
	}

	public Boolean isCrashed() {
		// TODO - implement Mobile.isCrashed
		throw new UnsupportedOperationException();
	}

	public Point getPosition() {
		return this.position;
	}

	/**
	 * 
	 * @param position
	 */
	public void setPosition(Point position) {
		this.position = position;
	}
}