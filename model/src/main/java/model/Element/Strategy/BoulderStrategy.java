package model.Element.Strategy;
import controller.IStrategy;
import model.IMap;
import model.IMobile;

public class BoulderStrategy extends FallingStrategy implements IStrategy
	{
		@Override
		public void followStrategy(IMobile currentPawn, IMap map)
		{
			followStrategy(currentPawn, map);
		}
	}
