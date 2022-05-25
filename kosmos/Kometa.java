package kosmos;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Panel;

public class Kometa extends NebeskoTelo {
	
	private int randSum; //svaka kometa ima neki random sum dodat na pocetni ugao od kog se krece crtanje

	public Kometa(int x, int y, Color boja, int pol) {
		super(x, y, boja, pol);
		randSum = (int) (Math.random() * 360);
		
	}

	//TODO formula?
	@Override
	public void crtaj(Graphics g) {
		g.setColor(boja);
		int xKord[] = new int[5];
		int yKord[] = new int[5];
		for(int i = 0; i < 5; i++) {
			xKord[i] = (int)(Math.cos(Math.toRadians(72*i+randSum))*poluprecnik) + x;
			yKord[i] = (int)(Math.sin(Math.toRadians(72*i+randSum))*poluprecnik) + y;
		}
		g.fillPolygon(xKord, yKord, 5);
	}
	

}
