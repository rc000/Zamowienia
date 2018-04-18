package gui;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.TypedQuery;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import klienci.Address;
import klienci.Klient;
import zamowienia.Zamowienie;

public class ControllClientAdd implements Initializable {

	@FXML
	Button bSaveClient;
	@FXML
	TextField tfName;
	@FXML
	TextField tfSurname;
	@FXML
	TextField tfStreet;
	@FXML
	TextField tfNrHome;
	@FXML
	TextField tfPlace;
	@FXML
	TextField tfPhone;
	@FXML
	Label validation;

	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		validation.setVisible(false);

	}

	@FXML
	public void ActionSaveClient(ActionEvent event) throws NullArgumentException, InterruptedException, Exception {
		validation.setVisible(false);
		Klient klient = new Klient();
		Address adres = new Address();
	 
		boolean valid = false;
		try {
			if (tfName.getText().isEmpty())
				throw new NullArgumentException("Imie");
			klient.setImie(tfName.getText());

			if (tfSurname.getText().isEmpty())
				throw new NullArgumentException("Nazwisko");
			klient.setNazwisko(tfSurname.getText());



			klient.setAdres(adres);

			if (tfStreet.getText().isEmpty())
				throw new NullArgumentException("Ulica");
			adres.setUlica(tfStreet.getText());

			if (tfNrHome.getText().isEmpty())
				throw new NullArgumentException("Nr domu");
			adres.setNrdomu(tfNrHome.getText());

			if (tfPlace.getText().isEmpty())
				throw new NullArgumentException("Miejscowosc");
			adres.setMiejscowosc(tfPlace.getText());
			if (tfPhone.getText().isEmpty())
				throw new NullArgumentException("Nr telefonu");
			klient.setNrtel(tfPhone.getText());
			valid = true;
		} catch (NullArgumentException e) {
			validation.setVisible(true);
			validation.setText("Pole " + e+" jest puste");
		}

		if (valid == true) {
			Main.getC().createEM();
			Main.getC().getEm().getTransaction().begin();
			Main.getC().getEm().persist(klient);
			Main.getC().getEm().persist(adres);
			 

			Main.getC().getEm().getTransaction().commit();

			Main.getC().close();
		}
	}

}
