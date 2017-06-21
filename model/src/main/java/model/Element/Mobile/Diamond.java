package model.Element.Mobile;

import java.util.Observable;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.Motionless.MotionlessElement;

public class Diamond extends Mobile {

	/** The Constant SPRITE. */
private static final Sprite SPRITE = new Sprite('D', "DIAMOND.jpj");

public Diamond(Sprite sprite, IMap Map, Permeability permeability) {
	super(sprite, Map, permeability);
}

@Override
public Boolean IsDie() {
	return null;
	
}

}