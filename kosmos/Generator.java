package kosmos;

import java.awt.Color;

public class Generator extends Thread {
	private Svemir svemir;
	private boolean radi = false;
	
	public Generator(Svemir sv) {
		svemir = sv;
		start();
	}
	
	@Override
	public void run() {
		try {
			while(!interrupted()) {
				synchronized (this) {
					while(!radi)wait();
				}
				int x = (int)(Math.random()*200);
				int y = 0;
				int r = (int)(10 + Math.random()*20);
				Kometa kom = new Kometa(x, y, Color.LIGHT_GRAY, r); //boja nije bitna
				svemir.dodajTelo(kom);
				Thread.sleep(900);
			}
		}catch(InterruptedException e) {}
	}
	
	
	public synchronized void kreni() {
		radi = true;
		notify();
	}
	
	public void zavrsi() {
		interrupt();
	}

}
