package Controller;
import View.IBoulderDashView;
import main.*;
import Model.IBoulderDashModel;
public abstract class BoulderDashController implements IBoulderDashController, IOrderPerformer {

	public int speed = 300;
	private IBoulderDashModel model;
	private IBoulderDashView view;

	public void play() {
		// TODO - implement BoulderDashController.play
		throw new UnsupportedOperationException();
	}

	private IBoulderDashView getView() {
		return this.view;
	}

	private IBoulderDashModel getModel() {
		return this.model;
	}

	/**
	 * 
	 * @param stackOrder
	 */
	private void getStackOrder(UserOrder stackOrder) {
		// TODO - implement BoulderDashController.getStackOrder
		throw new UnsupportedOperationException();
	}

	private void clearStackOrder() {
		// TODO - implement BoulderDashController.clearStackOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param view
	 * @param model
	 */
	public BoulderDashController(IBoulderDashView view, IBoulderDashModel model) {
		// TODO - implement BoulderDashController.BoulderDashController
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param view
	 */
	private void setView(IBoulderDashView view) {
		this.view = view;
	}

	/**
	 * 
	 * @param model
	 */
	private void setModel(IBoulderDashModel model) {
		this.model = model;
	}

	public IOrderPerformer getOrderPerformer() {
		// TODO - implement BoulderDashController.getOrderPerformer
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userOrder
	 */
	public void orderPerform(UserOrder userOrder) {
		// TODO - implement BoulderDashController.orderPerform
		throw new UnsupportedOperationException();
	}

}