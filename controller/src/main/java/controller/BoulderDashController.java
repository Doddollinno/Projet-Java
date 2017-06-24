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

public class BoulderDashController implements IBoulderDashController, IOrderPerformer {

    /** The view. */
	private IBoulderDashView view;
	
	/** The model. */
	private IBoulderDashModel model;
	
	  /** The actual speed of each loop in the game. */
	  private static final int StaticSpeed = 200;
	
	/** The stack order. */
    private UserOrder stackOrder = UserOrder.NOP;

	@Override
    public final void play() throws InterruptedException {
        while (this.getModel().getMyCharacter().isAlive()) {
            Thread.sleep(StaticSpeed);
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
                this.getModel().getMyCharacter().doNothing();
                if (this.getModel().getMap().getDiamondCount() == 0) {
                    this.getView().displayMessage("You won !! Congratulations ;) ");
                    System.exit(0);
                  }
            }
            this.getView().followMyCharacter();
        }
        this.getView().displayMessage("YOU DIED");
        System.exit(0);
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
     * Sets the stack order.
     *
     * @param stackOrder
     *            the new stack order
     */
    private void setStackOrder(final UserOrder stackOrder) {
        this.stackOrder = stackOrder;
    }

    /**
     * Instantiates a new boulder dash controller.
     *
     * @param view
     *            the view
     * @param model
     *            the model
     * @return 
     */
	public BoulderDashController(IBoulderDashModel model, IBoulderDashView view) {
        this.setModel(model);
		this.setView(view);
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