package enegretskisistem;

import java.awt.Color;

public abstract class Proizvodjac extends Parcela implements Runnable {
	
	private Baterija baterija;
	private long t;
	private Thread nit = new Thread(this);

	public Proizvodjac(char oznaka, Color poz, long t, Baterija b) {
		super(oznaka, poz);
		this.t = t;
		baterija = b;
		nit.start();
	}
	
	public long vremeProizvodnje() {
		return t + (long)(Math.random()*300);
	}

	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				Thread.sleep(vremeProizvodnje());
				
				try {
					int rez = proizvedi();
					baterija.dodajEnergiju(rez);
					postaviBojuTeksta(Color.RED);
					Thread.sleep(300);
					postaviBojuTeksta(Color.WHITE);
				} catch (GreskaProizvodnje e) {Thread.sleep(300);}
				
			}
		}catch(InterruptedException e) {}

	}
	
	abstract public int proizvedi() throws GreskaProizvodnje;

	public void zaustavi() {
		nit.interrupt();
	}

}
