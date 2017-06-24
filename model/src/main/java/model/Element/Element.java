package model.Element;

import java.awt.Image;

import model.IElement;
import model.Element.Permeability;
import model.Element.Sprite;

/**
 * An element is an object that can be used on an IBoard.
 *
 * @author Paul Combaldieu
 */
public abstract class Element implements IElement {

	/** The sprite. */
	private Sprite sprite;

	/** The permeability. */
	private Permeability permeability;

	/**
	 * Allows to Instantiates a new element.
	 *
	 * @param sprite
	 *            the sprite
	 * @param permeability
	 *            the permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/**
	 * Getter for the sprite.
	 *
	 * @return the sprite
	 * @see sprite
	 */
	@Override
	public final Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite
	 *            the new sprite
	 */
	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/**
	 * Getter for the permeability.
	 *
	 * @return the permeability
	 * @see Permeability
	 */
	@Override
	public final Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability
	 *            the new permeability
	 */
	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/**
	 * Getter for the image.
	 *
	 * @return the image
	 * @see java.awt.Image
	 */
	@Override
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}