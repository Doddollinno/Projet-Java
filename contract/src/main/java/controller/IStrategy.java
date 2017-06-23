package controller;

import model.IMap;
import model.IMobile;

public interface IStrategy {

	public void followStrategy(IMobile currentPawn, IMap map);
}
