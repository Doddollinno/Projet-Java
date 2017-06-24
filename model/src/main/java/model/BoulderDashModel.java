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

// TODO: Auto-generated Javadoc
/**
 * The Class BoulderDashModel.
 */
public class BoulderDashModel implements IBoulderDashModel {

	/** The map. */
	private Map map;

	/** The player's character. */
	private MyCharacter myCharacter;

	/**
	 * Instantiates a new model facade.
	 *
	 * @param mapID the map ID
	 * @throws SQLException the SQL exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public BoulderDashModel(final int mapID) throws SQLException, IOException {
		super();
		this.setMap(MapDAO.getMapById(mapID));
		this.myCharacter = new MyCharacter(1, 1, this.getMap());
	}

	/**
	 *  (non-Javadoc).
	 *
	 * @return the map
	 * @see model.IBoulderDashModel#getMap()
	 */
	public IMap getMap() {
		return (IMap) this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param newMap the new map
	 */
	public void setMap(final Map newMap) {
		this.map = newMap;
	}

	/**
	 * Sets the my character.
	 *
	 * @param newChara the new my character
	 */
	private void setMyCharacter(final MyCharacter newChara) {
		this.myCharacter = newChara;
	}

/**
 * Move pawns.
 */
public void movePawns() {
		ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

		if (this.getMyCharacter().isCrushed())
			this.getMyCharacter().die();
	}

	/** (non-Javadoc)
	 * @see model.IBoulderDashModel#getMyCharacter()
	 */
	public MyCharacter getMyCharacter() {
		return this.myCharacter;
	}
}