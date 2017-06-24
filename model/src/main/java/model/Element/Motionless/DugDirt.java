package model.Element.Motionless;

import javax.lang.model.element.Element;

import model.Element.Permeability;
import model.Element.Sprite;

// TODO: Auto-generated Javadoc
/**
 * The Class DugDirt.
 */
public class DugDirt extends MotionlessElement  {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "74359_02.png");

    /**
     * Instantiates a new ditch.
     */
    public DugDirt() {
    	super(SPRITE, Permeability.BLOCKING);
    }
}
