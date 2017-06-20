package model;

import java.util.Observable;

public interface IMap {

	int getWidth();

	int getHeight();

	/**
	 * 
	 * @param x
	 * @param y
	 */
	void getOnTheMapXY(int x, int y);

	void setMobileHasChanged();

	Observable getObservable();

}