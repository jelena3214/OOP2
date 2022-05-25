package enegretskisistem;

public class Baterija {
	private int trenutnaE, maxKap;
	
	public Baterija(int maxk) {
		maxKap = trenutnaE = maxk;
	}
	
	public void dodajEnergiju(int e) {
		trenutnaE = (trenutnaE + e) % maxKap;
	}
	
	public boolean puna() {
		return trenutnaE == maxKap;
	}
	
	public void isprazni() {
		trenutnaE = 0;
	}

}
