package model;

import java.awt.Image;

import fr.exia.showboard.ISquare;
import model.Element.Permeability;
import model.Element.Sprite;

/**
 * The interface that represents elements on the board.
 * @author Paul Combaldieu 
 *
 */
public interface IElement extends ISquare {

    /**
     * Gets the sprite.
     *
     * @return the sprite
     */
    Sprite getSprite();

    /**
     * Gets the permeability.
     *
     * @return the permeability
     */
    Permeability getPermeability();

    /*
     * (non-Javadoc)
     */
    Image getImage();

}