package model;

import model.Element.Mobile.IMobile;

public interface IBoulderDashModel {

	/**
     * Gets the Map
     *
     * @return the Map
     */
	IMap getMap();

	/**
     * Gets the Character
     *
     * @return the Character
     */
	IMobile getMyCharacter();

}