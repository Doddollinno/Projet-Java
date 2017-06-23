package model.Element.Strategy;
import model.IMap;
import model.IMobile;

public class BoulderStrategy extends FallingStrategy 
	{
		@Override
		public void followStrategy(IMobile currentPawn, IMap map)
		{
			super.followStrategy(currentPawn, map);
		}
	}
