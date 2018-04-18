package gui;

import java.net.URL;
import java.util.InputMismatchException;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import klienci.Klient;
import zamowienia.Zamowienie;

public class ControllAddOrder implements Initializable {

	@FXML
	TextField tfName;
	@FXML
	TextField tfColor;
	@FXML
	TextField tfDimension1;
	@FXML
	TextField tfDimension2;
	@FXML
	TextField tfDimension3;
	@FXML
	TextField tfQuantity;
	@FXML
	TextField tfPrice;
	@FXML
	Button bAddOrder;
	@FXML
	Label validation;
	private Klient klient;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	public Klient getKlient() {
		return klient;
	}

	public void setKlient(Klient klient) {
		this.klient = klient;
	}

	public void bl() {
		System.out.println("sdsd");
	}

	public boolean valid_dimensions(String dimensions) {
		Pattern pattern = Pattern.compile("[1-9][0-9]{1,3}x[1-9][0-9]{1,3}x[1-9][0-9]{1,3}");
		Matcher matcher = pattern.matcher(dimensions);
		if (!matcher.matches())
			return false;
		else
			return true;
	}

	@FXML
	public void ActionAddOrder(ActionEvent event) throws InterruptedException, Exception {
		validation.setVisible(true);
		validation.setText("");	
		Main.getC().createEM();
		
		Klient client_found;

		client_found = Main.getC().getEm().find(Klient.class, klient.getId());
		Zamowienie zamowienie = new Zamowienie();

		boolean valid = false;

		try {
			if (tfName.getText().isEmpty())
				throw new NullArgumentException("Nazwa");
			zamowienie.setNazwa(tfName.getText());

			if (tfColor.getText().isEmpty())
				throw new NullArgumentException("Kolor");
			zamowienie.setKolor(tfColor.getText());

			if (tfPrice.getText().isEmpty())
				throw new NullArgumentException("Cena");
			zamowienie.setCena(Double.parseDouble(tfPrice.getText()));

			if (tfQuantity.getText().isEmpty())
				throw new NullArgumentException("Ilosc");
			zamowienie.setIlosc(Double.parseDouble(tfQuantity.getText()));

			if (tfDimension1.getText().isEmpty() | tfDimension2.getText().isEmpty() | tfDimension3.getText().isEmpty())
				throw new NullArgumentException("Wymiary");

			valid = true;
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			validation.setVisible(true);
			validation.setText("Sprawdz poprawnosc ilosci lub ceny");
		} catch (NullArgumentException e) {
			// TODO Auto-generated catch block
			validation.setVisible(true);
			validation.setText("Pole " + e + " jest puste");
		}

		// zamowienie.setWymiary(tfDimension1.getText() + "x" +
		// tfDimension2.getText() + "x" + tfDimension3.getText());
		if (valid == true) {
			String dimensions = tfDimension1.getText() + "x" + tfDimension2.getText() + "x" + tfDimension3.getText();

			if (!valid_dimensions(dimensions)) {
				valid = false;
				validation.setText("B³êdne wymiary");

			} else {
				System.out.println(dimensions);
				zamowienie.setWymiary(dimensions);
			}
		}
		if (valid == true) {
			client_found.zwiekszLiczbeZamowien();
			validation.setText("Dodano poprawnie");
			zamowienie.setKoszt();
			zamowienie.setKlient(client_found);
			Main.getC().getEm().getTransaction().begin();
			Main.getC().getEm().persist(client_found);
			Main.getC().getEm().persist(zamowienie);
			Main.getC().getEm().getTransaction().commit();
			Main.getC().close();
		}
	}
}
