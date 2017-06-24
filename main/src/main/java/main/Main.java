package main;

import java.io.IOException;
import java.sql.SQLException;
import controller.BoulderDashController;
import model.BoulderDashModel;
import view.BoulderDashView;

/**
 * La classe principale
 *
 * @author Dorian Thériez, Michaël Desteuque, Aaron Sebagh, Benjamin Henry
 * @version 1.5
 */
public abstract class Main {

	public static void main(final String[] args) throws SQLException, IOException {

		final BoulderDashModel model = new BoulderDashModel(3);
		final BoulderDashView view = new BoulderDashView(model.getMap(), model.getMyCharacter(), model.getMap().getPawns());
		final BoulderDashController controller = new BoulderDashController(model, view);
		view.setOrderPerformer(controller.getOrderPeformer());

		try {
			controller.play();
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
}

