/*
 * 
 */
package model.Element.Strategy;

import model.IMap;
import model.IMobile;
import model.Element.Strategy.FallingStrategy;

// TODO: Auto-generated Javadoc
/**
 * The Class DiamondStrategy.
 */
public class DiamondStrategy extends FallingStrategy {

	/* (non-Javadoc)
	 * @see model.Element.Strategy.FallingStrategy#followStrategy(model.IMobile, model.IMap)
	 */
	public void followStrategy(IMobile currentPawn, IMap map) {
		if ((currentPawn.getPosition().y == map.getMyCharacter().getPosition().y - 1
				&& currentPawn.getPosition().x == map.getMyCharacter().getPosition().x)
				|| currentPawn.getPosition().equals(map.getMyCharacter().getPosition())) {
			currentPawn.removeFromBoard();
			map.decreaseDiamondCount();
			return;
		}
		if ((currentPawn.getPosition().y == map.getMyCharacter().getPosition().y) 
			&& currentPawn.getPosition().x == map.getMyCharacter().getPosition().x)
				map.addDiamondCount();
				currentPawn.removeFromBoard();
		super.followStrategy(currentPawn, map);
	}
}