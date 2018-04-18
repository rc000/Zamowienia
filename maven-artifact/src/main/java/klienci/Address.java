package klienci;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity
public class Address {
	@Id
	@GeneratedValue
	private int id;
	private String ulica;
	private String nrdomu;
	private String miejscowosc;

	public String getMiejscowosc() {
		return miejscowosc;
	}

	public StringProperty ulicaProperty()
	{
		SimpleStringProperty ulP=new SimpleStringProperty();
		ulP.set(this.ulica);
		return ulP;
	}
	public StringProperty nrDomuProperty()
	{
		SimpleStringProperty ndP=new SimpleStringProperty();
		ndP.set(this.nrdomu);
		return ndP;
	}
	public StringProperty miastoProperty()
	{
		SimpleStringProperty mP=new SimpleStringProperty();
		mP.set(this.miejscowosc);
		return mP;
	}
	public String getUlica() {
		return ulica;
	}

	public void setUlica(String ulica) {
		this.ulica = ulica;
	}

	public String getNrdomu() {
		return nrdomu;
	}

	public void setNrdomu(String nrdomu) {
		this.nrdomu = nrdomu;
	}

	public void setMiejscowosc(String miejscowosc) {
		this.miejscowosc = miejscowosc;
	}

	@Override
	public String toString() {
		return ulica + " " + nrdomu + " " + miejscowosc;
	}

}
