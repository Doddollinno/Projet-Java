package model;

import java.awt.Point;

import controller.UserOrder;
import fr.exia.showboard.IPawn;


public interface IMobile extends IPawn, IElement {


	void moveUp();

	void moveLeft();


	void moveDown();


	void moveRight();


	void doNothing();


	int getY();


	int getX(); 


	Boolean isAlive(); 


	Boolean IsDead();
	
    Boolean isCrushed();
    
    Boolean canMoveTo(final UserOrder direction);
    
	Point getPosition(); 
    public void followMyStrategy();
    
    public void removeFromBoard();
    
    public boolean isFalling();

	UserOrder getLastWallTouched();

	void setLastWallTouched(UserOrder userOrder);

    
    }