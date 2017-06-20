package view;

import model.IMap;
import model.Element.Mobile.IMobile;
import main.*;
import controller.UserOrder;


public class BoulderDashView implements IBoulderDashView {

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
	public BoulderDashView(IMap map, IMobile myVehicle) {
		// TODO - implement BoulderDashView.BoulderDashView
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	public void displayMessage(String message) {
		// TODO - implement BoulderDashView.displayMessage
		throw new UnsupportedOperationException();
	}

	public void run() {
		// TODO - implement BoulderDashView.run
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param yStart
	 */
	public void show(int yStart) {
		// TODO - implement BoulderDashView.show
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param keyCode
	 */
	public UserOrder keyCodeToUserOrder(int keyCode) {
		// TODO - implement BoulderDashView.keyCodeToUserOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param keyEvent
	 */
	public void keyTyped(KeyEvent keyEvent) {
		// TODO - implement BoulderDashView.keyTyped
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param keyEvent
	 */
	public void keyPressed(KeyEvent keyEvent) {
		// TODO - implement BoulderDashView.keyPressed
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param keyEvent
	 */
	public void keyReleased(KeyEvent keyEvent) {
		// TODO - implement BoulderDashView.keyReleased
		throw new UnsupportedOperationException();
	}

	public void getMap() {
		// TODO - implement BoulderDashView.getMap
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Map
	 */
	public void setMap(IMap Map) {
		// TODO - implement BoulderDashView.setMap
		throw new UnsupportedOperationException();
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
		// TODO - implement BoulderDashView.getCloseView
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param closeView
	 */
	private void setCloseView(Rectangle closeView) {
		// TODO - implement BoulderDashView.setCloseView
		throw new UnsupportedOperationException();
	}

	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * 
	 * @param orderPerformer
	 */
	public void setOrderPerformer(IOrderPerformer orderPerformer) {
		// TODO - implement BoulderDashView.setOrderPerformer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param message
	 */
	public void displayMessage(String message) {
		// TODO - implement BoulderDashView.displayMessage
		throw new UnsupportedOperationException();
	}

	public void followMyCharacter() {
		// TODO - implement BoulderDashView.followMyCharacter
		throw new UnsupportedOperationException();
	}

}