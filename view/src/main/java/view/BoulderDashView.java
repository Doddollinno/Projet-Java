package view;

import model.IMap;
import model.Element.Mobile.IMobile;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import controller.UserOrder;
import fr.exia.showboard.BoardFrame;

import javax.swing.JOptionPane;
import main.*;
import controller.

public class BoulderDashView implements IBoulderDashView, Runnable, KeyListener {

	private int mapView = 10;
	private int squareSize = 50;
	private int view;
	private IMap Map;
	private IMobile myCharacter;
	private IOrderPerformer orderPerformer;

	/**
	 * 
	 * @param map
	 * @param myVehicle
	 */
	public BoulderDashView(final IMap map, final IMobile MyCharacter) {
		this.setView(mapView);
        this.setMap(map);
        this.setMyCharacter(MyCharacter);
        this.getMyCharacter().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getMyCharacter().getY(), this.getMap().getWidth(), MapView));
        SwingUtilities.invokeLater(this);
	}

	/**
	 * 
	 * @param message
	 */
	public void displayMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(true);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.Map.getOnTheRoadXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyCharacter());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        this.followMyCharacter();

        boardFrame.setVisible(true);
    }

	/**
	 * 
	 * @param yStart
	 */
	public void show(int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getMyCharacter().getX()) && (y == yStart)) {
                    System.out.print(this.getMyCharacter().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheRoadXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
        }
    }

	/**
	 * 
	 * @param keyCode
	 */
	public UserOrder keyCodeToUserOrder(int keyCode) {
		 UserOrder userOrder;
		    switch (keyCode) {
		        case KeyEvent.VK_RIGHT:
		            userOrder = UserOrder.RIGHT;
		            break;
		        case KeyEvent.VK_LEFT:
		            userOrder = UserOrder.LEFT;
		            break;
		        case KeyEvent.VK_UP;
		        	userOrder = UserOrder.UP;
		        	break;
		        case KeyEvent.VK_DOWN;
		    		userOrder = UserOrder.DOWN;
		    		break;
		        default:
		            userOrder = UserOrder.NOP;
		            break;
		    }
		    return userOrder;
		}
			

	/**
	 * 
	 * @param keyEvent
	 */
	public void keyTyped(KeyEvent keyEvent) {
		//Nop
	}
	
    

	/**
	 * 
	 * @param keyEvent
	 */
	public void keyPressed(KeyEvent keyEvent) try {
        this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
    } catch (final IOException exception) {
        exception.printStackTrace();
    }
}
	/**
	 * 
	 * @param keyEvent
	 */
	public void keyReleased(KeyEvent keyEvent) {
		//Nop
	}

	private IMap getMap() {
		return this.map
	}

	/**
	 * 
	 * @param Map
	 */
	public void setMap(IMap Map) {
		this.Map = Map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                this.getMap().getOnTheRoadXY(x, y).getSprite().loadImage();
	}

	public IMobile getMyCharacter() {
		return this.myCharacter;
	}

	/**
	 * 
	 * @param myCharacter
	 */
	public void setMyCharacter(IMobile myCharacter) {
		this.myCharacter = myCharacter;
	}

	public int getView() {
		return this.view;
	}

	/**
	 * 
	 * @param view
	 */
	private void setView(int view) {
		this.view = view;
	}

	private Rectangle getCloseView() {
		return this.closeView;
	}

	/**
	 * 
	 * @param closeView
	 */
	private void setCloseView(Rectangle closeView) {
		this.closeView = closeView;
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * 
	 * @param orderPerformer
	 */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	

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

	}