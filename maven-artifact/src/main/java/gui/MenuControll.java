package gui;

import java.io.IOException;
import java.net.URL;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MenuControll {

	@FXML
	MenuItem mDodajK;

	@FXML
	public void ActionAddClient(ActionEvent event) throws IOException {
		URL dodawanie = getClass().getResource("/gui/fxml/ClientAdd.fxml");
		AnchorPane bar = FXMLLoader.load(dodawanie);
		BorderPane border = Main.getBorder();
		border.setCenter(bar);
	}

	public void ActionOverviewC(ActionEvent event) throws IOException {
		URL dodawanie = getClass().getResource("/gui/fxml/OverviewClient.fxml");
		AnchorPane bar = FXMLLoader.load(dodawanie);
		BorderPane border = Main.getBorder();
		border.setCenter(bar);
	}
	public void ActionChooseClient(ActionEvent event) throws IOException {
		
		URL dodawanie = getClass().getResource("/gui/fxml/ChooseClientForOrder.fxml");
		AnchorPane bar = FXMLLoader.load(dodawanie);
		BorderPane border = Main.getBorder();
		border.setCenter(bar);
	}


}
