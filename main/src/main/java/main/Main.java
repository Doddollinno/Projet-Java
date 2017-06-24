package main;

import java.io.IOException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import controller.BoulderDashController;
import controller.IBoulderDashController;
import model.BoulderDashModel;
import model.IBoulderDashModel;
import model.IModel;
import view.BoulderDashView;
import view.IBoulderDashView;

/**
 * La classe principale
 *
 * @author Dorian Thériez, Michaël Desteuque, Aaron Sebagh, Benjamin Henry
 * @version 1.5
 */
public abstract class Main {

	public static void main(final String[] args) throws SQLException, IOException {

		String idToAsk= JOptionPane.showInputDialog("ID MAP ", 1);
		int idAsked = Integer.parseInt(idToAsk);

		final BoulderDashModel model = new BoulderDashModel(idAsked);
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

