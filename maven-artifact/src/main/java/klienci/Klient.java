package klienci;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import zamowienia.Zamowienie;

@Entity
public class Klient {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String imie;
	private String nazwisko;
	@OneToOne
	@JoinColumn(name = "addressId")
	private Address adres;
	// private ObjectProperty<Address> adres=new SimpleObjectProperty();

	private String nrtel;
	@OneToMany(mappedBy="klient")
	List<Zamowienie> zamowienia;

	@Temporal(TemporalType.DATE)
	java.util.Date date = new java.util.Date();

	private int liczba_zamowien;
	public int getLiczba_zamowien() {
		return liczba_zamowien;
	}
	public void zwiekszLiczbeZamowien()
	{
		liczba_zamowien++;
	}
	public void setLiczba_zamowien(int liczba_zamowien) {
		this.liczba_zamowien = liczba_zamowien;
	}

	public void dodaj_zamowienie() {
		Zamowienie z = new Zamowienie();
		//z.dodaj_material();
		// zamowienia.add(z);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getImie() {
		return imie;
	}

	public void setImie(String imie) {
		this.imie = imie;
	}

	public String getNazwisko() {
		return nazwisko;
	}

	public void setNazwisko(String nazwisko) {
		this.nazwisko = nazwisko;
	}

	public String getNrtel() {
		return nrtel;
	}

	public void setNrtel(String nrtel) {
		this.nrtel = nrtel;
	}

	public void podaj_dane() {
		Scanner odczyt = new Scanner(System.in);
		System.out.println("Podaj imie");
		imie = odczyt.nextLine();
		System.out.println("Podaj nazwisko");
		nazwisko = odczyt.nextLine();
	}

	public Address getAddress() {
		return adres;
	}

	public void setAdres(Address adres) {
		this.adres = adres;
	}

	public ObservableValue<Address> obAdres() {
		ObservableValue<Address> obadres = new ReadOnlyObjectWrapper<>(this.adres);
		// new SimpleObjectProperty(this.adres).asObject();
		return obadres;
	}

	public java.util.Date getDate() {
		return date;
	}

	public void setDate(java.util.Date date) {
		this.date = date;
	}

	public void wyswietl_dane() {
		System.out.println("imie: " + imie);
		System.out.println("nazwisko: " + nazwisko);
	}

	/*
	 * public void wyswietl_zamowienie() { for (Zamowienie z : zamowienia) {
	 * z.wyswietl(); } }
	 */

}
