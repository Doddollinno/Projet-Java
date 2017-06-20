package model.Element.Motionless;

public abstract class MotionlessElementFactory {
	private String DugDirt;
	private String Dirt;
	private String Wall;
	private String Wallin;
	
	private static Wall Rectangle = new Wall();
	private Dirt DIRT = new Dirt();
	private DugDirt DUGDIRT = new DugDirt();
	private Wallin WALL = new Wallin();


	public abstract  MotionlessElement createWall();
	{
		
	}

	public MotionlessElement createDirt() {
		// TODO - implement MotionlessElementsFactory.createDirt
		throw new UnsupportedOperationException();
	}

	public MotionlessElement createDugDirt() {
		// TODO - implement MotionlessElementsFactory.createDugDirt
		throw new UnsupportedOperationException();
	}

	public MotionlessElement createWallin() {
		// TODO - implement MotionlessElementsFactory.createWall
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param fileSymbol
	 */
	public MotionlessElement getFromfileSymbole(char fileSymbol) {
		// TODO - implement MotionlessElementsFactory.getFromfileSymbole
		throw new UnsupportedOperationException();
	}

}