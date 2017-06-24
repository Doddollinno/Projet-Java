package model.Element.Motionless;

import javax.lang.model.element.Element;

import model.Element.Permeability;
import model.Element.Sprite;

public class DugDirt extends MotionlessElement  {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('V', "DUGDIRT.JPG");

    /**
     * Instantiates a new ditch.
     */
    public DugDirt() {
    	super(SPRITE, Permeability.PENETRABLE);
    }
}
