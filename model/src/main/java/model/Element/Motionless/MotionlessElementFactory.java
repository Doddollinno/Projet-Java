package model.Element.Motionless;

import javax.lang.model.element.Element;


import model.Element.Motionless.Wall;
import model.Element.Motionless.Dirt;
import model.Element.Motionless.DugDirt;

public abstract class MotionlessElementFactory {
	

	private static final Wall    wall 			= new Wall();
	private static final Dirt    dirt			= new Dirt();
	private static final DugDirt dugDirt 		= new DugDirt();


	private static MotionlessElement[]       motionlessElements  = {
	        wall,
	        dirt,
	        dugDirt};

	   
	 /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDugDirt() {
        return dugDirt;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createDirt() {
        return dirt;
    }

    /**
     * Creates a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static MotionlessElement createWall() {
        return wall;
    }
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
        for (final MotionlessElement motionlessElement : motionlessElements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
			}
		}
		return dugDirt;
	}		

}