package model.Element;

import java.awt.Image;

import model.IElement;

public class Element implements IElement 
{

	private Sprite sprite;

	private Permeability permeability;

	public Element(Sprite sprite, Permeability permeability) 
	{
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	public Sprite getSprite() 
	{
		return this.sprite;
	}

	public Permeability getPermeability() 
	{
		return this.permeability;
	}


	private void setPermeability(Permeability permeability) 
	{
		this.permeability = permeability;
	}

	public Image getImage() 
	{
		return this.getSprite().getImage();
	}

	/**
	 * 
	 * @param sprite
	 */
	protected void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

}