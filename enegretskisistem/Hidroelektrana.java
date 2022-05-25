package enegretskisistem;

import java.awt.Color;

public class Hidroelektrana extends Proizvodjac {
	
	private int brVodenihPovrsi;

	public Hidroelektrana(Baterija b) {
		super('H', Color.BLUE, 1500, b);
	}
	
	public void postaviBrojVodenihPovrsi(int br) {
		brVodenihPovrsi = br;
	}

	@Override
	public int proizvedi() throws GreskaProizvodnje{
		if(brVodenihPovrsi > 0) {
			return brVodenihPovrsi;
		}
		throw new GreskaProizvodnje();
	}

}
