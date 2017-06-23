package model.Element.Strategy;

import controller.IStrategy;
import controller.UserOrder;
import model.IMap;
import model.IMobile;
import model.Element.Permeability;

public abstract class FallingStrategy implements IStrategy{

	
	public abstract class FallingObjectsStrategy implements IStrategy {

		/**
		 * This Strategy applies to falling objects
		 * @param currentPawn refers to the object on wich this strategy may apply
		 * @param map refers to the map you move on.
		 */
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

						// if the current pawn can go to right
						if (currentPawn.canMoveTo(UserOrder.RIGHT)) {

							// if the current pawn can go slide to the right to fall
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