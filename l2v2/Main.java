package main;

import revija.*;

public class Main {

	public static void main(String[] args) {
		Velicina malaVelicina = new Velicina(Velicina.Oznaka.S);
		Velicina srednjaVelicina = new Velicina(Velicina.Oznaka.M);
		Velicina velikaVelicina = new Velicina(Velicina.Oznaka.L);

		System.out.println("Srednja velièina je: " + srednjaVelicina.dohvOznaku());
		if (malaVelicina.manja(srednjaVelicina)) {
			System.out.println("Velièina " + malaVelicina + " je manja od velièine " + srednjaVelicina);
		}

		Model model = new Model(srednjaVelicina);
		Odeca majica = new Odeca("Majica", malaVelicina);
		Nosivo pantalone = new Odeca("Pantalone", srednjaVelicina);

		System.out.println(model);
		String majicaOdgovara = (majica.odgovara(model)) ? "može" : "ne može";
		System.out.println("Model " + model.dohvId() + " velièine " + model.dohvVelicinu()
				+ " " + majicaOdgovara + " da obuèe majicu "
				+ majica.dohvNaziv() + " velièine " + majica.dohvVelicinu());
		System.out.println(pantalone);
		
		Kombinacija kombinacija = new Kombinacija(3);
		try {
			kombinacija.dodaj(majica);
			kombinacija.dodaj(pantalone);
			System.out.println(kombinacija);
			System.out.println("br stvari: " + kombinacija.dohvBrStvari() 
					+ "/" + kombinacija.dohvMaxBrStvari());
			kombinacija.dohvStvar(2);
		} catch (GDodavanje e) {
			System.out.println("Greška dodavanje!");
		} catch (GIndeks e) {
			System.out.println("Greška indeks!");
		}
	}

}
