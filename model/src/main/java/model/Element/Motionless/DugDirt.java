package model.Element.Motionless;

import model.Element.Permeability;
import model.Element.Sprite;

public class DugDirt extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('V', "DUGDIRT.JPG");

    /**
     * Instantiates a new ditch.
     */
    DugDirt() {
    	super(SPRITE, Permeability.PENETRABLE);
    }
}
