/*
 * 
 */
package model.Element.Strategy;
import controller.IStrategy;
import model.IMap;
import model.IMobile;

// TODO: Auto-generated Javadoc
/**
 * The Class BoulderStrategy.
 */
public class BoulderStrategy extends FallingStrategy implements IStrategy
	{
		
		/* (non-Javadoc)
		 * @see model.Element.Strategy.FallingStrategy#followStrategy(model.IMobile, model.IMap)
		 */
		@Override
		public void followStrategy(IMobile currentPawn, IMap map)
		{
			super.followStrategy(currentPawn, map);
		}
	}
