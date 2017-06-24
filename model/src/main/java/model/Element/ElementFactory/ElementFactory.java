package model.Element.ElementFactory;

import model.Element.Element;
import model.Element.Motionless.DugDirt;
import model.Element.Motionless.Dirt;
import model.Element.Motionless.Wall;

/**
 * Motionless element factory. 
 * @author Aaron
 * 
 * @version 1.0
 */
public abstract class ElementFactory {
	  /** The Constant wall. */
    private static final Wall        		 wall          		 = new Wall();

    /** The Constant dugDirt. */
    private static final DugDirt	         dugDirt             = new DugDirt();

    /** The Constant filledDirt. */
    private static final Dirt   		 filledDirt   		 = new Dirt();

    /**
     * The motionless elements is an array of all possible MotionlessElement.
     * used for get from char symbol
     */
    private static Element[]       elements  = {
        dugDirt,
        filledDirt,
        wall
     };

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createDugDirt() {
        return dugDirt;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createDirt() {
        return filledDirt;
    }

    /**
     * Create a new MotionlessElements object.
     *
     * @return the motionless element
     */
    public static Element createWall() {
        return wall;
    }

    /**
     * Gets the good MotionlessElement from file symbol.
     *
     * @param fileSymbol
     *            the file symbol
     * @return the from file symbol
     */
    public static Element getFromFileSymbol(final char fileSymbol) {
        for (final Element motionlessElement : elements) {
            if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
                return motionlessElement;
            }
        }
        return dugDirt;
    }
}