package model.Element.Strategy;

import controller.IStrategy;
import model.IMap;
import model.IMobile;
import model.Element.Mobile.Monster;

public class MonsterStrategy implements IStrategy {

	@Override
	public void followStrategy(IMobile currentPawn, IMap map) {
		if(currentPawn.isCrushed()) {
			Monster monster = (Monster)(currentPawn);
			monster.removeStrategy();
			monster.removeFromBoard();
		}
	}

		
	}


