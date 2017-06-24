package controller;

import model.IMap;
import model.IMobile;

/**
 * The Interface IStrategy.
 */
public interface IStrategy {

	/**
	 * Follow strategy.
	 *
	 * @param currentPawn the current pawn
	 * @param map the map
	 */
	public void followStrategy(IMobile currentPawn, IMap map);
}
