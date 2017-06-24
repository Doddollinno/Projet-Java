package view;


import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.IOrderPerformer;
import controller.UserOrder;
import model.IMap;
import model.IMobile;
import fr.exia.showboard.BoardFrame;

/**
 * The Class GenericView.</h1>
 * 
 * @author Aaron
 * @version 1.0
 */
public class BoulderDashView implements IBoulderDashView, Runnable, KeyListener {
	/** The Constant squareSize. */
	protected static final int squareSize = Toolkit.getDefaultToolkit().getScreenSize().width / 20;

	/** The map. */
	protected IMap map = null;

	/** The player's character. */
	protected IMobile myCharacter = null;

	/** The list of pawns. */
	protected ArrayList<IMobile> pawns = null;

	/** The close view. */
	protected Rectangle closeView = null;

	/** The order performer. */
	protected IOrderPerformer orderPerformer = null;

	/** The BoardFrame. */
	protected final BoardFrame boardFrame = new BoardFrame("BoulderDash");

	/**
	 * Key code to user order.
	 *
	 * @param keyCode
	 *            the key code
	 * @return the user order
	 */
	
	public BoulderDashView (final IMap map, final IMobile character, final ArrayList<IMobile> pawns) throws IOException {
		super();
		this.setMap(map);
		this.setMyCharacter(character);
		this.setPawns(pawns);
		this.setCloseView(this.getReasonableViewPort());
		SwingUtilities.invokeLater(this);
	}
	
	
	protected static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	protected void setMyCharacter(final IMobile newCharacter) {
		this.myCharacter = newCharacter;
	}

	protected IMobile getMyCharacter() {
		return this.myCharacter;
	}

	protected void setCloseView(final Rectangle newView) {
		this.closeView = newView;
	}

	/**
	 * Gets a reasonable size for the close view depending on the map.
	 * 
	 * @return A rectangle with reasonable dimensions
	 */
	protected Rectangle getReasonableViewPort() {
		int reasonableWidth;
		int reasonableHeight;

		// First let's find a reasonable width
		if ((int) (map.getWidth() * 0.75) > 10) {
			reasonableWidth = 10;
		} else if ((int) (map.getWidth() * 0.75) < 5) {
			reasonableWidth = map.getWidth();
		} else {
			reasonableWidth = (int) (map.getWidth() * 0.75);
		}

		// Now the same with height
		if ((int) (map.getHeight() * 0.75) > 10) {
			reasonableHeight = 10;
		} else if ((int) (map.getHeight() * 0.75) < 5) {
			reasonableHeight = map.getHeight();
		} else {
			reasonableHeight = (int) (map.getHeight() * 0.75);
		}

		return new Rectangle(0, 0, reasonableWidth, reasonableHeight);
	}

	protected IMap getMap() {
		return this.map;
	}

	public Rectangle getCloseView() {
		return closeView;
	}

	protected IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	public void setOrderPerformer(final IOrderPerformer newPerformer) {
		this.orderPerformer = newPerformer;
	}

	/**
	 * Update the board frame and redraws squares.
	 */
	public void updateBoardFrame() {
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
	}
	
	/**
	 * 
	 * @param newPawns
	 *            The pawn list.
	 */
	protected void setPawns(final ArrayList<IMobile> newPawns) {
		this.pawns = newPawns;
	}



	/**
	 * Displays the message in dialog box.
	 * 
	 * @see contract.view.IView#displayMessage(java.lang.String)
	 */
	@Override
	public final void displayMessage(final String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	private void setMap(final IMap newMap) throws IOException {
		this.map = newMap;
		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
	}

	@Override
	public final void run() {
		boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
		boardFrame.setDisplayFrame(this.closeView);
		boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
		boardFrame.addKeyListener(this);
		boardFrame.setFocusable(true);
		boardFrame.setFocusTraversalKeysEnabled(false);

		for (int x = 0; x < this.getMap().getWidth(); x++) {
			for (int y = 0; y < this.getMap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		boardFrame.addPawn(this.getMyCharacter());
		for (IMobile pawn : this.pawns) {
			boardFrame.addPawn(pawn);
		}

		this.getMap().getObservable().addObserver(boardFrame.getObserver());
		this.followMyCharacter();

		boardFrame.setVisible(true);

	}

	/**
	 * Move the view to focus on the character.
	 */
	@Override
	public void followMyCharacter() {
		this.getCloseView().y = (int) (this.myCharacter.getY() - (this.getCloseView().getHeight() / 2));
		this.getCloseView().x = (int) (this.myCharacter.getX() - (this.getCloseView().getWidth() / 2));

		if (this.myCharacter.getY() < this.getCloseView().getHeight() / 2) {
			this.getCloseView().y = 0;
		} else if (this.myCharacter.getY() > (this.map.getHeight() - (this.getCloseView().getHeight() / 2))) {
			this.getCloseView().y = (int) (this.map.getHeight() - this.getCloseView().getHeight());
		}
		if (this.myCharacter.getX() < this.getCloseView().getWidth() / 2) {
			this.getCloseView().x = 0;
		} else if (this.myCharacter.getX() > (this.map.getWidth() - (this.getCloseView().getWidth() / 2))) {
			this.getCloseView().x = (int) (this.map.getWidth() - this.getCloseView().getWidth());
		}
	}
}