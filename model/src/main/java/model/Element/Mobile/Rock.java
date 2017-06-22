package model.Element.Mobile;

import model.IMap;
import model.Element.Permeability;
import model.Element.Sprite;

public class Rock extends Mobile {

	private static final Sprite SPRITE = new Sprite('R', "ROCK.jpj");
	
	public Rock(int x, int y, Sprite sprite, IMap Map, Permeability permeability) {
		super(x, y, sprite, Map, permeability);
		
			
		}
	}

	@Override
	public Boolean IsDead() {
		return null;
	}
	
	
			
		
	}

}
