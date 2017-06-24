package controller;

import java.sql.SQLException;

public interface IController {

	 void start() throws InterruptedException, SQLException;

	 IOrderPerformer getOrderPeformer();
}


