package zamowienia;

import java.util.Scanner;

public class Material {

	private String nazwa,kolor, wymiary;
	private double ilosc, cena,koszt;
	
	public void dodaj()
	{
			Scanner odczyt = new Scanner(System.in);
			System.out.println("Podaj nazwe");
			nazwa=odczyt.nextLine();
			System.out.println("Podaj kolor");
			kolor=odczyt.nextLine();
			System.out.println("Podaj wymiar");
			wymiary=odczyt.nextLine();
			System.out.println("Podaj ilosc");
			ilosc=odczyt.nextDouble();
			System.out.println("Podaj cene");
			cena=odczyt.nextDouble();
			koszt =ilosc*cena;
	}
	public void wyswietl()
	{
		System.out.println("nazwa: "+nazwa);
		System.out.println("kolor: "+kolor);
		System.out.println("wymiar: "+wymiary);
		System.out.println("ilosc: "+ilosc);
		System.out.println("cena: "+cena);
		System.out.println("koszt: "+koszt);


	}
}
