package controller;
import view.IBoulderDashView;
import model.IBoulderDashModel;
import controller.IBoulderDashController;


import java.io.IOException;

/**
 * <h1>The Class BoulderDashController.</h1>
 *
 * @author Aaron
 * @version 0.1
 * @see IOrderPerformer
 */

public abstract class BoulderDashController implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed. */
    private static final int speed = 300;

    /** The view. */
	private IBoulderDashView view;
	
	/** The model. */
	private IBoulderDashModel model;
	
	/** The stack order. */
    private UserOrder stackOrder;

    @Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyCharacter().isAlive()) {
            Thread.sleep(speed);
            switch (this.getStackOrder()) {
                case RIGHT:
                    this.getModel().getMyCharacter().moveRight();
                    break;
                case UP:
                    this.getModel().getMyCharacter().moveUp();
                    break;
                case DOWN:
                    this.getModel().getMyCharacter().moveDown();
                    break;
                case LEFT:
                    this.getModel().getMyCharacter().moveLeft();
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
        this.getView().displayMessage("YOU DIED");
    }

	private IBoulderDashView getView() {
		return this.view;
	}

	private IBoulderDashModel getModel() {
		return this.model;
	}

	/**
     * Gets the stack order.
     *
     * @return the stack order
     */
    private UserOrder getStackOrder() {
        return this.stackOrder;
    }

    /**
     * Clear stack order.
     */
    private void clearStackOrder() {
        this.stackOrder = UserOrder.NOP;
    }

    /**
     * Instantiates a new boulder dash controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
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

	@Override
    public IOrderPerformer getOrderPeformer() {
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