package controller;

import java.io.IOException;

public abstract class BoulderDashController implements IBoulderDashController, IOrderPerformer {

	public int speed = 300;
	private IBoulderDashModel model;
	private IBoulderDashView view;
	private UserOrder stackOrder;

	@Override
	public final void play() throws InterruptedException {
        while (this.getModel().getMyCharacter().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyCharacter().moveRight();
                    break;
                case LEFT:
                    this.getModel().getMyCharacter().moveLeft();
                    break;
                case UP:
                	this.getModel().getMyCharacter().moveUp();
                	break;
                case DOWN:
                	this.getModel().getMyCharacter().moveDown();
                	break;
                case NOP:
                default:
                    this.getModel().getMyCharacter().doNothing();
                    break;
            }
            this.clearStackOrder();
            if (this.getModel().getMyCharacter().isAlive()) {
                this.getModel().getMyCharacter().moveDown();
            }
            this.getView().followMyCharacter();
        }
        this.getView().displayMessage("YOU DIED.");
    }

	/**
     * Gets the view.
     *
     * @return the view
     */
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
		return this.stackOrder;
	}

	/**
     * Clear stack order.
     */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/**
	 * 
	 * @param view
	 * @param model
	 */
	public BoulderDashController(IBoulderDashView view, IBoulderDashModel model) {
		this.setView(view);
        this.setModel(model);
        this.clearStackOrder();
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
		return this;
	}

	/**
	 * 
	 * @param userOrder
	 */
	@Override
    public final void orderPerform(final UserOrder userOrder) throws IOException {
        this.setStackOrder(userOrder);
    }

}