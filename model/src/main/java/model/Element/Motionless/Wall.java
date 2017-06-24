package model.Element.Motionless;

import model.Element.Permeability;
import model.Element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class Wall.
 */
public class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('W', "Wall.jpj");

    /**
     * Instantiates a new ditch.
     */
    public Wall() {
    	super(SPRITE, Permeability.BLOCKING);
    }
}
