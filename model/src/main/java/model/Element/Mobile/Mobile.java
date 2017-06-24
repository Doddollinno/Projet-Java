package model.Element.Mobile;

import java.awt.Point;

import java.io.IOException;

import controller.UserOrder;
import fr.exia.showboard.IBoard;
import model.IMap;
import model.IMobile;
import model.Element.Element;
import model.Element.Permeability;
import model.Element.Sprite;
import model.Element.ElementFactory.ElementFactory;




public abstract class Mobile extends Element implements IMobile {


		private Point position;


		private Boolean alive = true;


		private IMap map;


		private IBoard board;


		private boolean fallSpeed = false;
		



		Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
			super(sprite, permeability);
			this.map = map;
			this.position = new Point();
		}


		Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
			this(sprite, map, permeability);
			this.getPosition().x = x;
			this.getPosition().y = y;
		}

		@Override
		public void moveUp() {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}

		@Override
		public void moveLeft() {
			this.setX(this.getX() - 1);
			this.setHasMoved();
		}

		@Override
		public void moveDown() {
			this.setY(this.getY() + 1);
			this.setHasMoved();
			this.fallSpeed = true;
		}

		@Override
		public void moveRight() {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}

		@Override
		public void doNothing() {
			this.setHasMoved();
			this.fallSpeed = false;
		}


		private void setHasMoved() {
			this.getMap().setMobileHasChanged();
		}

		@Override
		public final int getX() {
			return this.getPosition().x;
		}

		public final void setX(final int x) {
			this.getPosition().x = x;
			if (this.isCrushed()) {
				this.die();
			}
		}


		public void dugDirt() throws IOException {
			this.getMap().setOnTheMapXY(this.getX(), this.getY(), ElementFactory.createDugDirt());
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();
		}

		@Override
		public final int getY() {
			return this.getPosition().y;
		}

		public final void setY(final int y) {
			this.getPosition().y = y;
			if (this.isCrushed()) {
				this.die();
			}
		}


		public IMap getMap() {
			return this.map;
		}

		@Override
		public Boolean isAlive() {
			return this.alive;
		}


		protected void die() {
			this.alive = false;
			this.setHasMoved();
		}


		public Boolean isCrushed() {
			for (IMobile pawn : this.getMap().getPawns()) {
				if (pawn.getSprite().getConsoleImage() == 'O' || pawn.getSprite().getConsoleImage() == 'V') {
					if (pawn.getPosition().x == this.getPosition().x
							&& pawn.getPosition().y == this.getPosition().y - 1 && pawn.isFalling()) {
						return true;
					}
				}
			}
			return this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.BLOCKING;
		}


		public Boolean canMoveTo(final UserOrder direction) {
			return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
		}


		protected boolean mapAllowsMovementTo(final UserOrder direction) {
			switch (direction) {
			case UP:
				return this.getMap().getOnTheMapXY(this.getX(), this.getY() - 1)
						.getPermeability() == Permeability.PENETRABLE;
			case DOWN:
				return this.getMap().getOnTheMapXY(this.getX(), this.getY() + 1)
						.getPermeability() == Permeability.PENETRABLE;
			case RIGHT:
				return this.getMap().getOnTheMapXY(this.getX() + 1, this.getY())
						.getPermeability() == Permeability.PENETRABLE;
			case LEFT:
				return this.getMap().getOnTheMapXY(this.getX() - 1, this.getY())
						.getPermeability() == Permeability.PENETRABLE;
			case NOP:
			default:
				return true;
			}
		}


		protected Boolean pawnsAllowMovementTo(final UserOrder direction) {
			Point desiredPosition = this.getPositionFromUserOrder(direction);
			for (IMobile pawn : this.getMap().getPawns()) {
				if (pawn.getPosition().equals(desiredPosition)) {
					if (pawn.getPermeability() != Permeability.PENETRABLE) {
						return false;
					} else {
						return true;
					}
				}
			}

			return true;
		}
		
		protected Point getPositionFromUserOrder(final UserOrder direction){
			Point desiredPosition = null;
			switch (direction) {
			case UP:
				desiredPosition = new Point(this.getX(), this.getY() - 1);
				break;
			case DOWN:
				desiredPosition = new Point(this.getX(), this.getY() + 1);
				break;
			case RIGHT:
				desiredPosition = new Point(this.getX() + 1, this.getY());
				break;
			case LEFT:
				desiredPosition = new Point(this.getX() - 1, this.getY());
				break;
			case NOP:
			default:
				desiredPosition = new Point(this.getX(), this.getY());
				break;
			}
			
			return desiredPosition;
		}

		@Override
		public Point getPosition() {
			return this.position;
		}



		public void setPosition(final Point position) {
			this.position = position;
		}


		protected IBoard getBoard() {
			return this.board;
		}

		public boolean isFalling() {
			return fallSpeed;
		}


		public void removeFromBoard() {
			this.setPosition(new Point(1, -1));
			this.getMap().getPawns().remove(this);
		}


		@Override
		public UserOrder getLastWallTouched() {
			// nop
			return UserOrder.NOP;
		}

		@Override
		public void setLastWallTouched(final UserOrder userOrder) {
			// nop
		}

}