/*
 * 
 */
package model.Element.Strategy;

import controller.IStrategy;
import model.IMap;
import model.IMobile;
import model.Element.Mobile.Monster;

// TODO: Auto-generated Javadoc
/**
 * The Class MonsterStrategy.
 */
public class MonsterStrategy implements IStrategy {

	/* (non-Javadoc)
	 * @see controller.IStrategy#followStrategy(model.IMobile, model.IMap)
	 */
	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		if(currentPawn.isCrushed()) {
			Monster monster = (Monster)(currentPawn);
			monster.removeFromBoard();
		}
	}

		
	}


