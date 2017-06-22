package controller;

import java.awt.image.BufferedImage;
import java.util.Observer;
import model.BoulderDashModel;

public class BoulderController{
	
	private BoulderDashModel level;
	
	/*
	 * Need a BoulderDashModel Class and a Playfield class to work, which give the number of the current level.
	 * A level is composed of a play field and some other
	 * informations (rocks, diamonds, walls, monsters initial positions...)
	 * BoulderDashModel class has row, column, DiamondsToWin attributes
	 */


	public GameController(final BoulderDashModel level)
	{
		this.level = level;
		
	}
	
	/*
	 * public BoulderDashModel(final int row, final int column, final int DiamondsToWin)
	 *{
	 *	this.playField = new PlayField(rows, columns);
	 *	this.DiamondsToWin = DiamondsToWin;
	 *}
	 */

	/**
	 * @return the number of columns in the current level play field
	 */
	public int getColumns()
	{
		return model.getPlayField().getColumnsCount();
	}
	
	/*
	 * Need a class PlayField and Character to work. 
	 * 
	 * public PlayField(final int rows, final int columns)
	{
		this.panel = new Panel2DArrayImpl(rows, columns);
		this.character = new Character();
		this.exit = new Exit();
	}
	 */

	/**
	 * @return the number of rows in the current level play field
	 */
	public int getRows()
	{
		return model.getPlayField().getRowsCount();
	}

	/**
	 * @return the default size for one sprite element.
	 */
	public static int getSpriteSize()
	{
		return 16;
	}

	/**
	 * Start the game loop for the current level.
	 */
	public void startGame()
	{
		try {
			level.start();
		} catch ( InterruptedException e ) {
			e.printStackTrace();
		}
	}

	/**
	 * Register a view as a level observer
	 * 
	 * @param observer
	 *            the view that will become observer
	 */
	public void registerObserver(final Observer observer)
	{
		level.addObserver(observer);
	}

	/**
	 * @return the number of diamonds that Rocford has already collected
	 */
	public int getDiamondsCollectedCount()
	{
		return level.getPlayField().getCharacter().getDiamondsCount();
	}

	/**
	 * @return the number of diamonds you need to collect to be allowed to exit the game
	 */
	public int getDiamondsToWin()
	{
		int count = level.getDiamondsToWin() - getDiamondsCollectedCount();
		return count >= 0 ? count : 0;
	}
	
	/** 
	 * @return the number of diamonds you have already collected
	 */

	public boolean isFinish()
	{
		return level.isFinish();
	}


	public boolean isWin()
	{
		return level.isFinish() && level.getCharacter().isAlive();
	}

}