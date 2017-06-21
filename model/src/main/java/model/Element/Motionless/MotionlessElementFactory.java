package model.Element.Motionless;

public abstract class MotionlessElementFactory {
;
	
	private static Wall Rectangle = new Wall();
	private Dirt DIRT = new Dirt();
	private DugDirt DUGDIRT = new DugDirt();
	private Wallin WALL = new Wallin();


	
	/**
	 * 
	 * @param fileSymbol
	 */
	public MotionlessElement getFromfileSymbole(char fileSymbol) {
		// TODO - implement MotionlessElementsFactory.getFromfileSymbole
		throw new UnsupportedOperationException();
	}

}