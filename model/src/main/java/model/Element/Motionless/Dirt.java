package model.Element.Motionless;

import java.awt.Image;

import model.Element.Permeability;
import model.Element.Sprite;

public class Dirt extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "74359_03.png");

                                                                                                       /**�
     * Instantiates a new ditch.
     */
    public Dirt() {
    	super(SPRITE, Permeability.PENETRABLE);
    }
}
