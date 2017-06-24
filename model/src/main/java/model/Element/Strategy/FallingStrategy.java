/*
 * 
 */
package model.Element.Strategy;

import controller.IStrategy;


import controller.UserOrder;
import model.IMap;
import model.IMobile;
import model.Element.Permeability;


	
	// TODO: Auto-generated Javadoc
/**
	 * The Class FallingStrategy.
	 */
	public abstract class FallingStrategy implements IStrategy {


		/* (non-Javadoc)
		 * @see controller.IStrategy#followStrategy(model.IMobile, model.IMap)
		 */
		@Override
		public void followStrategy(IMobile currentPawn, IMap map) {
			if (currentPawn.canMoveTo(UserOrder.DOWN)) {
				currentPawn.moveDown();
			} else {

				for (IMobile pawnVerif : map.getPawns()) {
					if (currentPawn.getPosition().y == pawnVerif.getPosition().y - 1
							&& currentPawn.getPosition().x == pawnVerif.getPosition().x) {
						if (currentPawn.canMoveTo(UserOrder.LEFT)) {
							if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
									pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
								currentPawn.moveLeft();
								return;
							}
						}
						if (currentPawn.canMoveTo(UserOrder.RIGHT)) {
							if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x + 1,
									pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
								currentPawn.moveRight();
								return;
							}
						}
					}
				}
				currentPawn.doNothing();
			}
		}

	}