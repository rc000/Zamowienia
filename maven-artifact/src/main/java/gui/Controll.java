package gui;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import klienci.Klient;

public class Controll  implements Initializable {
	Stage primaryStage;
	@FXML Button bStart;
	@FXML MenuItem mDodajK;
	@FXML MenuBar mBar;
	


	public void setStage(Stage stage) throws FileNotFoundException, ClassNotFoundException, IOException
	{
		 	    
				 primaryStage=stage;
					URL menuBarUrl = getClass().getResource("/gui/fxml/MenuBar.fxml");
					MenuBar bar = FXMLLoader.load( menuBarUrl );
				      BorderPane border = Main.getBorder();
				      border.setTop(bar);
		 
	}
	@FXML
	public void ActionButton(ActionEvent event) throws InterruptedException, Exception
	{
	
		Klient klient=new Klient();
		klient.podaj_dane();
	}
	@FXML
	public void ActionAddClient(ActionEvent event) throws IOException
	{
        Parent home_page_parent = FXMLLoader.load(getClass().getResource("/gui/fxml/ClientAdd.fxml"));
        Scene home_page_scene = new Scene(home_page_parent);
         Stage stage = (Stage) mBar.getScene().getWindow();

         stage.setScene(home_page_scene);
        stage.show();


	}
	@FXML
	public void ActionOverviewC(ActionEvent event) throws IOException
	{
 	}
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
}
