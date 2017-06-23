package model.Element.Strategy;

import model.IMap;
import model.IMobile;
import model.Element.Strategy.FallingStrategy;

public class DiamondStrategy extends FallingStrategy {

	public void followStrategy(IMobile currentPawn, IMap map) {
		// if the currentPawn is above the player
		if ((currentPawn.getPosition().y == map.getMyCharacter().getPosition().y - 1
				&& currentPawn.getPosition().x == map.getMyCharacter().getPosition().x)
				|| currentPawn.getPosition().equals(map.getMyCharacter().getPosition())) {
			currentPawn.removeFromBoard();
			map.decreaseDiamondCount();
			return;
		}
		super.followStrategy(currentPawn, map);
	}
}