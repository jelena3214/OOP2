package kosmos;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Svemir extends Canvas implements Runnable {
	private Thread nit = new Thread(this);
	private ArrayList<NebeskoTelo> nebeskaTela = new ArrayList<>();
	private boolean radi = false;
	
	public Svemir() {
		setBackground(Color.BLACK);
		nit.start();
	}
	
	public synchronized void dodajTelo(NebeskoTelo nt) {
		nebeskaTela.add(nt);
	}
	
	@Override
	public void run() {
		try {
			while(!Thread.interrupted()) {
				synchronized (this) { //while?
					while(!radi)wait();
				}
				repaint();
				simuliraj();
				Thread.sleep(100);
			}
		}catch(InterruptedException e) {}

	}
	//sync?
	private synchronized void simuliraj() {
		for(NebeskoTelo t: nebeskaTela) {
			t.pomeriY(5);
		}
	}
	
	@Override
	public void paint(Graphics g) {
		for(NebeskoTelo t: nebeskaTela) {
			t.crtaj(g);
		}
	}
	
	public synchronized void pokreni() {
		radi = true;
		notify();
	}
	
	public void zavrsi() {
		nit.interrupt();
	}

}
