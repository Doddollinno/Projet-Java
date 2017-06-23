package model;

import java.awt.Image;

import model.Element.Permeability;
import model.Element.Sprite;

public interface IElement {

	Sprite getSprite();

	Permeability getPermeability();

	Image getImage();



}