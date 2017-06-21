package model.Element.Mobile;

import java.awt.Point;

public interface IMobile {

	/**
	 * Move up.
	 */
	void moveUp();

	/** 
	 * Move Left.
	 */
	void moveLeft();

	/**
	 * Move Down
	 */
	void moveDown();

	/**
	 * Move Right
	 */
	void moveRight();

	/**
	 * Do nothing
	 */
	void doNothing();

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	int getY();

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	int getX(); 

	/**
	 * Checks if he is alive.
	 *
	 * @return the alive
	 */
	Boolean isAlive(); 

	/**
	 * Checks if he is dead.
	 *
	 * @return the dead
	 */
	Boolean IsDie();

	/*
	 * (non-Javadoc)
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	Point getPosition(); 
}