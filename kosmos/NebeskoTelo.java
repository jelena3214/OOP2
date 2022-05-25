package kosmos;

import java.awt.Color;
import java.awt.Graphics;

public abstract class NebeskoTelo extends Objekat {

	protected int poluprecnik;
	
	public NebeskoTelo(int x, int y, Color boja, int pol) {
		super(x, y, boja);
		poluprecnik = pol;
	}

}
