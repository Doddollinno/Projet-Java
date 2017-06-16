package Classe;

public class BoulderDashController implements IOrderPerformer, IBoulderDashController {

	public int speed = 300;
	private IBoulderDashModel model;
	private IBoulderDashVehiclesView view;

	public void play() {
		// TODO - implement BoulderDashController.play
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

	private IBoulderDashView getView() {
		// TODO - implement BoulderDashController.getView
		throw new UnsupportedOperationException();
	}

	private IBoulderDashViewModel getModel() {
		// TODO - implement BoulderDashController.getModel
		throw new UnsupportedOperationException();
	}

	private UserOrder getStackOrder() {
		// TODO - implement BoulderDashController.getStackOrder
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param stackOrder
	 */
	private void setStackOrder(UserOrder stackOrder) {
		// TODO - implement BoulderDashController.setStackOrder
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
	public BoulderDashController(IBoulderdashView view, IBouldeDashModel model) {
		// TODO - implement BoulderDashController.BoulderDashController
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param view
	 */
	private void setView(IBoulderDashView view) {
		// TODO - implement BoulderDashController.setView
		throw new UnsupportedOperationException();
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

}