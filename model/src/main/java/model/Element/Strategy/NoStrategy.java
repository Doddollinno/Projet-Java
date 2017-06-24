/*
 * 
 */
package model.Element.Strategy;

import model.IMap;
import model.IMobile;

// TODO: Auto-generated Javadoc
/**
 * A strategy that does nothing. Used when monsters are taken out of the board.
 * 
 * 
 * @author Aaron
 * @version 1.0
 *
 */
public class NoStrategy extends MonsterStrategy {

	/* (non-Javadoc)
	 * @see model.Element.Strategy.MonsterStrategy#followStrategy(model.IMobile, model.IMap)
	 */
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		// Nop
	}
}