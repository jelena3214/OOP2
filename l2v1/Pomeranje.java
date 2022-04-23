package banditi;

public class Pomeranje extends Akcija {

	private Smer smer;
	
	public Pomeranje(Kompozicija k, Smer s) {
		super(k);
		smer = s;
	}

	@Override
	public void izvrsi(Bandit b) {
		
		try {
			Vagon trenutni = komp.dohvatiVagon(b);
			Vagon sledeci = komp.dohvatiSusedniVagon(trenutni, smer);
			trenutni.ukloniBandita(b);
			sledeci.dodajBandita(b);
		} catch (GNepostojeciVagon e) {
			return;
		}
	}
	
	@Override
	public String toString() {
		return "Pomeranje:" + smer.name();
	}

}
