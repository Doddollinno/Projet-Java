package model.Element.Strategy;

import controller.IStrategy;


import controller.UserOrder;
import model.IMap;
import model.IMobile;
import model.Element.Permeability;


	
	public abstract class FallingStrategy implements IStrategy {


		@Override
		public void followStrategy(IMobile currentPawn, IMap map) {
			// Check : can the Pawn go down ?
			if (currentPawn.canMoveTo(UserOrder.DOWN)) {
				currentPawn.moveDown();
			} else {

				// If not : Can pawn fall on the sides ?
				for (IMobile pawnVerif : map.getPawns()) {

					// If there is a current pawn under this pawn.
					if (currentPawn.getPosition().y == pawnVerif.getPosition().y - 1
							&& currentPawn.getPosition().x == pawnVerif.getPosition().x) {

						// Can the pawn go left ?
						if (currentPawn.canMoveTo(UserOrder.LEFT)) {

							// Can the Pawn slide and fall to the left ?
							if (map.getSquareIsOccupiedXY(pawnVerif.getPosition().x - 1,
									pawnVerif.getPosition().y) == Permeability.PENETRABLE) {
								currentPawn.moveLeft();
								return;
							}
						}

						// Can the pawn go right ?
						if (currentPawn.canMoveTo(UserOrder.RIGHT)) {

							// Can the Pawn slide and fall to the right ?
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