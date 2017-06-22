package model;

import java.util.Observable;

public interface IMap {

    /**
     * Gets the width.
     *
     * @return the width
     */
	int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
	int getHeight();

    /**
     * Gets the on the road XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
	void getOnTheMapXY(int x, int y);

	/**
     * Sets the mobile has changed.
     */	
	void setMobileHasChanged();
	
    /**
     * Gets the observable.
     *
     * @return the observable
     */
	Observable getObservable();

}