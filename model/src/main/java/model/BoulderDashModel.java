package model;

import model.Element.Sprite;
import model.Element.Mobile.MyCharacter;
import model.dao.MapDAO;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.IMap;
import model.IModel;

import model.Map;

public class BoulderDashModel implements IBoulderDashModel {

	/** The map. */
	private Map map;

	/** The player's character. */
	private MyCharacter myCharacter;

	/**
	 * Instantiates a new model facade.
	 * @return 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public BoulderDashModel(final int mapID) throws SQLException, IOException {
		super();
		this.setMap(MapDAO.getMapById(mapID));
		this.myCharacter = new MyCharacter(1, 1, this.getMap());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getExampleById(int)
	 */
	public IMap getMap() {
		return (IMap) this.map;
	}

	public void setMap(final Map newMap) {
		this.map = newMap;
	}

	private void setMyCharacter(final MyCharacter newChara) {
		this.myCharacter = newChara;
	}

public void movePawns() {
		ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

		if (this.getMyCharacter().isCrushed())
			this.getMyCharacter().die();
	}

	public MyCharacter getMyCharacter() {
		return this.myCharacter;
	}
}