import model.Element.Mobile.MyCharacter;

public abstract class BoulderDashModel implements IModel {

	/** The map. */
	private IMap map;

	/** The player's character. */
	private MyCharacter myCharacter;

	/**
	 * Instantiates a new model facade.
	 * @return 
	 * 
	 * @throws SQLException
	 * @throws IOException
	 */
	public void ModelFacade(final int mapID) throws SQLException, IOException {
		super();
		Sprite.loadBuffers();
		this.setMap(MapDAO.getMapById(mapID));
		this.setMyCharacter(new MyCharacter(1, 1, this.getMap()));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see model.IModel#getExampleById(int)
	 */
	@Override
	public IMap getMap() {
		return this.map;
	}

	public void setMap(final Map newMap) {
		this.map = newMap;
	}

	private void setMyCharacter(final MyCharacter newChara) {
		this.myCharacter = newChara;
	}

	/**
	 * Moves pawns (boulders, diamonds, ...).
	 * Their movement is related to their strategy.
	 */
	public void movePawns() {
		ArrayList<IMobile> copyPawns = new ArrayList<>(this.getMap().getPawns());
		
		for (IMobile pawn : copyPawns) {
			pawn.followMyStrategy();
		}

		if (this.getMyCharacter().isCrushed())
			this.getMyCharacter().die();
	}

	@Override
	public MyCharacter getMyCharacter() {
		return this.myCharacter;
	}