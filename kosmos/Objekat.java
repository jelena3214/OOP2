package kosmos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class Objekat {
	
	protected int x, y;
	protected Color boja;
	
	public Objekat(int x, int y, Color boja) {
		super();
		this.x = x;
		this.y = y;
		this.boja = boja;
	}

	public int dohvX() {
		return x;
	}

	public int dohvY() {
		return y;
	}
	
	public void pomeriX(int pom) {
		x += pom;
	}
	
	public void pomeriY(int pom) {
		y += pom;
	}
	
	abstract public void crtaj(Graphics g);
	

}
