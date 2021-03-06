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




/**
 * The Class Mobile.
 */
public abstract class Mobile extends Element implements IMobile {


		/** The position. */
		private Point position;


		/** The alive. */
		private Boolean alive = true;


		/** The map. */
		private IMap map;


		/** The board. */
		private IBoard board;


		/** The fall speed. */
		private boolean fallSpeed = false;
		



		/**
		 * Instantiates a new mobile.
		 *
		 * @param sprite the sprite
		 * @param map the map
		 * @param permeability the permeability
		 */
		Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
			super(sprite, permeability);
			this.map = map;
			this.position = new Point();
		}


		/**
		 * Instantiates a new mobile.
		 *
		 * @param x the x
		 * @param y the y
		 * @param sprite the sprite
		 * @param map the map
		 * @param permeability the permeability
		 */
		Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
			this(sprite, map, permeability);
			this.getPosition().x = x;
			this.getPosition().y = y;
		}

		/** (non-Javadoc)
		 * @see model.IMobile#moveUp()
		 */
		@Override
		public void moveUp() {
			this.setY(this.getY() - 1);
			this.setHasMoved();
		}

		/** (non-Javadoc)
		 * @see model.IMobile#moveLeft()
		 */
		@Override
		public void moveLeft() {
			this.setX(this.getX() - 1);
			this.setHasMoved();
		}

		/** (non-Javadoc)
		 * @see model.IMobile#moveDown()
		 */
		@Override
		public void moveDown() {
			this.setY(this.getY() + 1);
			this.setHasMoved();
			this.fallSpeed = true;
		}

		/** (non-Javadoc)
		 * @see model.IMobile#moveRight()
		 */
		@Override
		public void moveRight() {
			this.setX(this.getX() + 1);
			this.setHasMoved();
		}

		/** (non-Javadoc)
		 * @see model.IMobile#doNothing()
		 */
		@Override
		public void doNothing() {
			this.setHasMoved();
			this.fallSpeed = false;
		}


		/**
		 * Sets the has moved.
		 */
		private void setHasMoved() {
			this.getMap().setMobileHasChanged();
		}

		/** (non-Javadoc)
		 * @see model.IMobile#getX()
		 */
		@Override
		public final int getX() {
			return this.getPosition().x;
		}

		/**
		 * Sets the x.
		 *
		 * @param x the new x
		 */
		public final void setX(final int x) {
			this.getPosition().x = x;
			if (this.isCrushed()) {
				this.die();
			}
		}


		/**
		 * Dug dirt.
		 *
		 * @throws IOException Signals that an I/O exception has occurred.
		 */
		public void dugDirt() throws IOException {
			this.getMap().setOnTheMapXY(this.getX(), this.getY(), ElementFactory.createDugDirt());
			this.getMap().getOnTheMapXY(getX(), getY()).getSprite().loadImage();
		}

		/** (non-Javadoc)
		 * @see model.IMobile#getY()
		 */
		@Override
		public final int getY() {
			return this.getPosition().y;
		}

		/**
		 * Sets the y.
		 *
		 * @param y the new y
		 */
		public final void setY(final int y) {
			this.getPosition().y = y;
			if (this.isCrushed()) {
				this.die();
			}
		}


		/**
		 * Gets the map.
		 *
		 * @return the map
		 */
		public IMap getMap() {
			return this.map;
		}

		/** (non-Javadoc)
		 * @see model.IMobile#isAlive()
		 */
		@Override
		public Boolean isAlive() {
			return this.alive;
		}


		/**
		 * Die.
		 */
		protected void die() {
			this.alive = false;
			this.setHasMoved();
		}


		/** (non-Javadoc)
		 * @see model.IMobile#isCrushed()
		 */
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


		/** (non-Javadoc)
		 * @see model.IMobile#canMoveTo(controller.UserOrder)
		 */
		public Boolean canMoveTo(final UserOrder direction) {
			return this.mapAllowsMovementTo(direction) && this.pawnsAllowMovementTo(direction);
		}


		/**
		 * Map allows movement to.
		 *
		 * @param direction the direction
		 * @return true, if successful
		 */
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


		/**
		 * Pawns allow movement to.
		 *
		 * @param direction the direction
		 * @return the boolean
		 */
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
		
		/**
		 * Gets the position from user order.
		 *
		 * @param direction the direction
		 * @return the position from user order
		 */
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

		/** (non-Javadoc)
		 * @see model.IMobile#getPosition()
		 */
		@Override
		public Point getPosition() {
			return this.position;
		}



		/**
		 * Sets the position.
		 *
		 * @param position the new position
		 */
		public void setPosition(final Point position) {
			this.position = position;
		}


		/**
		 * Gets the board.
		 *
		 * @return the board
		 */
		protected IBoard getBoard() {
			return this.board;
		}

		/** (non-Javadoc)
		 * @see model.IMobile#isFalling()
		 */
		public boolean isFalling() {
			return fallSpeed;
		}


		/** (non-Javadoc)
		 * @see model.IMobile#removeFromBoard()
		 */
		public void removeFromBoard() {
			this.setPosition(new Point(1, -1));
			this.getMap().getPawns().remove(this);
		}


		/** (non-Javadoc)
		 * @see model.IMobile#getLastWallTouched()
		 */
		@Override
		public UserOrder getLastWallTouched() {
			// nop
			return UserOrder.NOP;
		}

		/** (non-Javadoc)
		 * @see model.IMobile#setLastWallTouched(controller.UserOrder)
		 */
		@Override
		public void setLastWallTouched(final UserOrder userOrder) {
			// nop
		}

}