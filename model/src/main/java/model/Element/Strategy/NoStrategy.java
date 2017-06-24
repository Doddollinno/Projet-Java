package model.Element.Strategy;

import model.IMap;
import model.IMobile;

/**
 * A strategy that does nothing. Used when monsters are taken out of the board.
 * 
 * 
 * @author Aaron
 * @version 1.0
 *
 */
public class NoStrategy extends MonsterStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// Nop
	}
}