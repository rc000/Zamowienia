package zamowienia;

import java.util.List;
import java.util.Vector;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import klienci.Klient;

@Entity
public class Zamowienie {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nazwa,kolor, wymiary;
	private double ilosc, cena,koszt;
	@Temporal(TemporalType.DATE)
	java.util.Date date = new java.util.Date();
	@ManyToOne
	@JoinColumn(name="klientId")
	private Klient klient;
		public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNazwa() {
		return nazwa;
	}
	public void setNazwa(String nazwa) {
		this.nazwa = nazwa;
	}
	public String getKolor() {
		return kolor;
	}
	public void setKolor(String kolor) {
		this.kolor = kolor;
	}
	public String getWymiary() {
		return wymiary;
	}
	public void setWymiary(String wymiary) {
		this.wymiary = wymiary;
	}
	public double getIlosc() {
		return ilosc;
	}
	public void setIlosc(double ilosc) {
		this.ilosc = ilosc;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public double getKoszt() {
		return koszt;
	}
	public void setKoszt() {
		this.koszt = this.cena*this.ilosc;
	}
	public java.util.Date getDate() {
		return date;
	}
	public void setDate(java.util.Date date) {
		this.date = date;
	}
	public Klient getKlient() {
		return klient;
	}
	public void setKlient(Klient klient) {
		this.klient = klient;
	}

}
