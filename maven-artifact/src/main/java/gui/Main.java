package gui;

import java.net.URL;

import javax.persistence.EntityTransaction;

import database.Connect;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import javafx.stage.Stage;
import klienci.Klient;

public class Main extends Application {

	static BorderPane stack = new BorderPane();
	private static Connect c;

	public static Connect getC() {
		return c;
	}

	public static void setC(Connect c) {
		Main.c = c;
	}

	public static BorderPane getBorder() {
		return stack;
	}

	public static void main(String[] args) throws Exception {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		c = new Connect();
		c.createEMF();

		// TODO Auto-generated method stub
		// pracownicy.wczytaj();
		// TODO Auto-generated method stub
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("/gui/fxml/Layout.fxml"));
		stack = loader.load();
		Controll Controller = loader.getController();
		Scene scena = new Scene(stack);
		primaryStage.setScene(scena);
		primaryStage.setTitle("Zapis zamówien");
		primaryStage.show();

		Controller.setStage(primaryStage);

	}
}