package revija;

public class Kombinacija {
	private int brojStvari;
	private Nosivo[] nosiveStvari;
	
	public Kombinacija(int brojStvari) {
		nosiveStvari = new Nosivo[brojStvari];
	}
	
	public void dodaj(Nosivo stvar) throws GDodavanje{
		if(brojStvari == nosiveStvari.length - 1)throw new GDodavanje("Popunjena kombinacija");
		nosiveStvari[brojStvari++] = stvar;
	}
	
	public int dohvBrStvari(){
		return brojStvari;
	}
	
	public int dohvMaxBrStvari(){
		return nosiveStvari.length;
	}
	
	public Nosivo dohvStvar(int i) throws GIndeks{
		if(i < 0 || i >= nosiveStvari.length || nosiveStvari[i] == null)throw new GIndeks("Indeks izvan opsega");
		return nosiveStvari[i];
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < brojStvari; i++){
			sb.append(nosiveStvari[i]);
			if(i < brojStvari - 1)sb.append(", ");
		}
		sb.append("]");
		
		return sb.toString();
	}
	
}
