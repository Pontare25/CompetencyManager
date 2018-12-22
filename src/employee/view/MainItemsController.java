package employee.view;

import java.io.IOException;

import employee.Main;
import javafx.fxml.FXML;

public class MainItemsController {
	
	private Main main;
	
	@FXML
	private void goElectrical() throws IOException {
		main.showElectricalScene();
		
	}
	
	@FXML
	private void goMechanical() throws IOException {
		main.showMechanicalScene();
	}

}
