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
	private IMap Map; 

	/** 
	 * Instantiates a new mobile
	 * 
	 * @param sprite
	 * 				the sprite
	 * @param Map
	 * 				the Map
	 * @param permeability
	 * 				the permeability
	 */
	public Mobile(Sprite sprite, IMap Map, Permeability permeability) {
		super (sprite, permeability);
		this.Map = Map;
		this.position = new Point();

	}

	/**
	 * 
	 * @param x
	 * @param y
	 * @param sprite
	 * @param Map
	 * @param permeability
	 */
	public Mobile(final int x, final int y, final Sprite sprite, final IMap Map, final Permeability permeability) {
		super (sprite, permeability);
		this.setX(x);
		this.setY(y);
	}

	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	public void doNothing() {
		this.setHasMoved();
	}

	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/**
	 * 
	 * @param x
	 */
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * 
	 * @param x
	 */
	public final void setX(final int x) {
		this.getPosition().x = x;
		if (this.IsDie()) {
			this.die();
		}
	}

	public int getY() {
		return this.getPosition().y;
	}

	/**
	 * 
	 * @param y
	 */
	public final void setY(final int y) {
		this.getPosition().y = (y + this.getMap().getHeight()) % this.getMap().getHeight();
		if (this.IsDie()) {
			this.die();
		}
	}

	public IMap getMap() {
		return this.Map;
	}

	/**
	 * 
	 * @param map
	 */
	private void setMap(IMap map) {
		this.Map = map;
	}

	public Boolean isAlive() {
		return this.Alive;
	}

	protected void die() {
		this.Alive = false;
		this.setHasMoved();
	}

		public Point getPosition() {
			return this.position;
		}

		public Boolean IsDie() {
			return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
		}
		/**
		 * 
		 * @param position
		 */
		public void setPosition(Point position) {
			this.position = position;
		}
}